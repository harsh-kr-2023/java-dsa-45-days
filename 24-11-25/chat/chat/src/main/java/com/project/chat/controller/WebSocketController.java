package com.project.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

    // When a task is updated, broadcast to all clients
    @MessageMapping("/task.update")
    @SendTo("/topic/tasks")
    public Map<String, Object> broadcastTaskUpdate(Map<String, Object> taskUpdate) {
        System.out.println("📢 Broadcasting task update: " + taskUpdate);
        return taskUpdate;
    }

    // When a new task is created, broadcast to all clients
    @MessageMapping("/task.create")
    @SendTo("/topic/tasks")
    public Map<String, Object> broadcastNewTask(Map<String, Object> newTask) {
        System.out.println("🆕 Broadcasting new task: " + newTask);
        return newTask;
    }

    // Simple chat for collaboration
    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Map<String, String> broadcastChat(Map<String, String> chatMessage) {
        System.out.println("💬 Chat message: " + chatMessage.get("message"));
        return chatMessage;
    }
}