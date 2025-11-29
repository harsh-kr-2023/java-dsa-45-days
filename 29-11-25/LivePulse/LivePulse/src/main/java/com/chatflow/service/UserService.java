package com.chatflow.service;

import com.chatflow.dto.RegisterRequest;
import com.chatflow.model.User;
import com.chatflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Register a new user
     */
    public User registerUser(RegisterRequest registerRequest) {
        // Check if username already exists
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Check if email already exists
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create new user
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Hash password
        user.setProfilePicture(registerRequest.getProfilePicture());
        user.setOnline(false);
        user.setLastSeen(LocalDateTime.now());

        return userRepository.save(user);
    }

    /**
     * Authenticate user (login)
     */
    public User authenticateUser(String username, String password) {
        // Find user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Update user status
        user.setOnline(true);
        user.setLastSeen(LocalDateTime.now());
        userRepository.save(user);

        return user;
    }

    /**
     * Search users by username (for finding friends to chat with)
     */
    public List<User> searchUsers(String username, Long excludeUserId) {
        return userRepository.searchByUsername(username, excludeUserId);
    }

    /**
     * Get user by username
     */
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Update user online status
     */
    public void updateUserStatus(Long userId, boolean online) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setOnline(online);
        user.setLastSeen(LocalDateTime.now());
        userRepository.save(user);
    }
}