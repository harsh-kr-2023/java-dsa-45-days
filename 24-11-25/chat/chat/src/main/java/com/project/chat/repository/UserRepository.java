package com.project.chat.repository;

import com.project.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // ADD THESE METHODS:
    Optional<User> findById(Long id); // This might already exist from JpaRepository
}