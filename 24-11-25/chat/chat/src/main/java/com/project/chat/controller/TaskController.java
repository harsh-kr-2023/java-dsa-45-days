package com.project.chat.controller;

import com.project.chat.model.Project;
import com.project.chat.model.Task;
import com.project.chat.model.User;
import com.project.chat.repository.ProjectRepository;
import com.project.chat.repository.TaskRepository;
import com.project.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects/{projectId}/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET: Get all tasks for a project
    @GetMapping
    public ResponseEntity<List<Task>> getProjectTasks(@PathVariable Long projectId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (!project.getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        List<Task> tasks = taskRepository.findByProject(project);
        return ResponseEntity.ok(tasks);
    }

    // POST: Create a new task in a project
    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (!project.getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        task.setProject(project);
        task.setStatus(Task.Status.TODO);
        Task savedTask = taskRepository.save(task);

        // FIXED: Use explicit casting
        messagingTemplate.convertAndSend("/topic/tasks", (Object) Map.of(
                "type", "TASK_CREATED",
                "task", savedTask,
                "projectId", projectId
        ));

        return ResponseEntity.ok(savedTask);
    }

    // PUT: Update a task
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long projectId,
                                           @PathVariable Long taskId,
                                           @RequestBody Task taskDetails) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getProject().getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        if (taskDetails.getTitle() != null) {
            task.setTitle(taskDetails.getTitle());
        }
        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getStatus() != null) {
            task.setStatus(taskDetails.getStatus());
        }
        if (taskDetails.getPriority() != null) {
            task.setPriority(taskDetails.getPriority());
        }

        Task updatedTask = taskRepository.save(task);

        // FIXED: Use explicit casting
        messagingTemplate.convertAndSend("/topic/tasks", (Object) Map.of(
                "type", "TASK_UPDATED",
                "task", updatedTask,
                "projectId", projectId
        ));

        return ResponseEntity.ok(updatedTask);
    }

    // DELETE: Delete a task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getProject().getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        taskRepository.delete(task);

        // FIXED: Use explicit casting
        messagingTemplate.convertAndSend("/topic/tasks", (Object) Map.of(
                "type", "TASK_DELETED",
                "taskId", taskId,
                "projectId", projectId
        ));

        return ResponseEntity.ok().build();
    }

    // Add this to your existing TaskController.java
    @PutMapping("/{taskId}/assign")
    public ResponseEntity<Task> assignTask(@PathVariable Long projectId,
                                           @PathVariable Long taskId,
                                           @RequestParam Long userId) {
        // Security check
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Check if user owns the project
        if (!task.getProject().getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build();
        }

        User assignee = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setAssignedTo(assignee);
        Task updatedTask = taskRepository.save(task);

        // Real-time notification
        messagingTemplate.convertAndSend("/topic/tasks", (Object) Map.of(
                "type", "TASK_ASSIGNED",
                "task", updatedTask,
                "assignee", assignee.getUsername(),
                "projectId", projectId
        ));

        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String query) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Task> tasks = taskRepository.searchTasks(username, query);
        return ResponseEntity.ok(tasks);
    }
}