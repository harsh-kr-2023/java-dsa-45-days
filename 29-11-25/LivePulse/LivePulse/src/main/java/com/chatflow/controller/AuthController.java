package com.chatflow.controller;

import com.chatflow.dto.AuthRequest;
import com.chatflow.dto.AuthResponse;
import com.chatflow.dto.RegisterRequest;
import com.chatflow.model.User;
import com.chatflow.service.JwtService;
import com.chatflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        try {
            // Register the user
            User user = userService.registerUser(registerRequest);

            // Generate JWT token
            String token = jwtService.generateToken(user);

            // Return response with token and user info (without password)
            user.setPassword(null); // Don't send password back
            AuthResponse response = new AuthResponse(token, "User registered successfully", user);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new AuthResponse(e.getMessage()));
        }
    }

    /**
     * Login user
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest) {
        try {
            // Authenticate user
            User user = userService.authenticateUser(authRequest.getUsername(), authRequest.getPassword());

            // Generate JWT token
            String token = jwtService.generateToken(user);

            // Return response with token and user info
            user.setPassword(null); // Don't send password back
            AuthResponse response = new AuthResponse(token, "Login successful", user);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new AuthResponse(e.getMessage()));
        }
    }

    /**
     * Test endpoint - to verify JWT is working
     * This endpoint requires authentication
     */
    @GetMapping("/test")
    public ResponseEntity<String> testAuth() {
        return ResponseEntity.ok("JWT Authentication is working! 🎉");
    }
}