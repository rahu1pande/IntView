package com.intView.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intView.exception.UserAlreadyExistsException;
import com.intView.model.User;
import com.intView.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(User user) {
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("This email address is already registered. Please use a different email or try logging in.");
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        // Save user
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
