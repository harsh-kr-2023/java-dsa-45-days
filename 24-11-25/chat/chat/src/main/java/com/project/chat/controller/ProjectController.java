package com.project.chat.controller;

import com.project.chat.model.Project;
import com.project.chat.model.User;
import com.project.chat.repository.ProjectRepository;
import com.project.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    // GET: Get all projects for the current user
    @GetMapping
    public ResponseEntity<List<Project>> getUserProjects() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Project> projects = projectRepository.findByOwner(user);
        return ResponseEntity.ok(projects);
    }

    // POST: Create a new project (automatically sets current user as owner)
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        project.setOwner(user);
        Project savedProject = projectRepository.save(project);
        return ResponseEntity.ok(savedProject);
    }

    // GET: Get specific project (only if user is owner)
    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable Long projectId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        // Check if current user is the owner
        if (!project.getOwner().getUsername().equals(username)) {
            return ResponseEntity.status(403).build(); // Forbidden
        }

        return ResponseEntity.ok(project);
    }
}