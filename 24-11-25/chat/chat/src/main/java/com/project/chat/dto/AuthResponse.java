package com.project.chat.dto;

import com.project.chat.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data                    // ← Generates ALL getters/setters/toString/equals/hashCode
@NoArgsConstructor       // ← Generates: public AuthRequest() {}
@AllArgsConstructor      // ← Generates: public AuthRequest(String username, String password) {}
public class AuthResponse {
    private String token;
    private String message;
    private User user;
}