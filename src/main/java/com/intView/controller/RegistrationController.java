package com.intView.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.intView.exception.UserAlreadyExistsException;
import com.intView.model.User;
import com.intView.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            // Add specific error messages for each field
            if (result.hasFieldErrors("password")) {
                model.addAttribute("passwordError", 
                    "Password must be at least 8 characters long and contain at least one digit, one uppercase letter, one lowercase letter, and one special character (@#$%^&+=)");
            }
            if (result.hasFieldErrors("firstName")) {
                model.addAttribute("firstNameError", 
                    "First name must be between 2 and 50 characters and can only contain letters, spaces, hyphens, and apostrophes");
            }
            if (result.hasFieldErrors("lastName")) {
                model.addAttribute("lastNameError", 
                    "Last name must be between 2 and 50 characters and can only contain letters, spaces, hyphens, and apostrophes");
            }
            if (result.hasFieldErrors("email")) {
                model.addAttribute("emailError", 
                    "Please provide a valid email address");
            }
            return "register";
        }

        // Check if passwords match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Passwords do not match");
            return "register";
        }

        try {
            userService.registerUser(user);
            model.addAttribute("success", 
                "Registration successful");
            return "redirect:/login";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("emailError", e.getMessage());
            return "register";
        } catch (Exception e) {
            model.addAttribute("error", 
                "Registration failed. Please try again later.");
            return "register";
        }
    }
} 