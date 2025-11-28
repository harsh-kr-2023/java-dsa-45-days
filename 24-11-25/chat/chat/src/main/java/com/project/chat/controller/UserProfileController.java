package com.project.chat.controller;

import com.project.chat.model.Task;
import com.project.chat.model.User;
import com.project.chat.repository.ProjectRepository;
import com.project.chat.repository.TaskRepository;
import com.project.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getUserStats() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        long projectCount = projectRepository.countByOwner(user);
        long taskCount = taskRepository.countByProjectOwner(user);
        long completedTasks = taskRepository.countByProjectOwnerAndStatus(user, Task.Status.DONE);

        return ResponseEntity.ok(Map.of(
                "projectCount", projectCount,
                "taskCount", taskCount,
                "completedTasks", completedTasks
        ));
    }
}