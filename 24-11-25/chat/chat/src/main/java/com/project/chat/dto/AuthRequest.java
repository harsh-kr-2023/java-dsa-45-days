package com.project.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data                    // ← Generates ALL getters/setters/toString/equals/hashCode
@NoArgsConstructor       // ← Generates: public AuthRequest() {}
@AllArgsConstructor      // ← Generates: public AuthRequest(String username, String password) {}
public class AuthRequest {
    private String username;
    private String password;
}