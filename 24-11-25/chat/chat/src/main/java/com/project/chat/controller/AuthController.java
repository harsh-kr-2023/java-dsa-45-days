package com.project.chat.controller;

import com.project.chat.dto.AuthRequest;
import com.project.chat.dto.AuthResponse;
import com.project.chat.dto.RegisterRequest;
import com.project.chat.model.User;
import com.project.chat.service.UserService;
import com.project.chat.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            User user = userService.registerUser(registerRequest);

            // Generate JWT token for the new user
            String token = jwtUtil.generateToken(user.getUsername());

            AuthResponse response = new AuthResponse(
                    token,
                    "User registered successfully",
                    user
            );
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    new AuthResponse(null, e.getMessage(), null)
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            User user = userService.authenticateUser(
                    authRequest.getUsername(),
                    authRequest.getPassword()
            );

            // Generate JWT token
            String token = jwtUtil.generateToken(user.getUsername());

            AuthResponse response = new AuthResponse(
                    token,
                    "Login successful",
                    user
            );
            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    new AuthResponse(null, e.getMessage(), null)
            );
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("This is a protected endpoint! JWT is working!");
    }

    @GetMapping("/debug-auth")
    public ResponseEntity<?> debugAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> debugInfo = new HashMap<>();
        debugInfo.put("authenticated", auth.isAuthenticated());
        debugInfo.put("username", auth.getName());
        debugInfo.put("authorities", auth.getAuthorities().toString());
        debugInfo.put("principal", auth.getPrincipal().toString());
        debugInfo.put("securityEnabled", true);

        return ResponseEntity.ok(debugInfo);
    }

    @GetMapping("/protected-test")
    public ResponseEntity<String> protectedTest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.isAuthenticated() ? auth.getName() : "Anonymous";

        return ResponseEntity.ok("JWT Protected endpoint works! User: " + username + " | Authenticated: " + auth.isAuthenticated());
    }
}