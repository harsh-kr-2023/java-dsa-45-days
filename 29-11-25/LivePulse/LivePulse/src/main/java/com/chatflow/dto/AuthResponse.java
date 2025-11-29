package com.chatflow.dto;

import com.chatflow.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token; // JWT token
    private String message;
    private User user; // User details without password

    // Constructors for different scenarios
    public AuthResponse(String token, String message, User user) {
        this.token = token;
        this.message = message;
        this.user = user;
    }

    public AuthResponse(String message) {
        this.message = message;
    }
}