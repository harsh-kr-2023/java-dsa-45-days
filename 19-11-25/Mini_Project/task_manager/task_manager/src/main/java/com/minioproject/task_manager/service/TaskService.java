package com.minioproject.task_manager.service;

import com.minioproject.task_manager.model.Task;
import com.minioproject.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE or UPDATE
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // READ all
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // READ by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // DELETE by ID
    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted";
    }
}
