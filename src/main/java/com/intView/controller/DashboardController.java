package com.intView.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.intView.model.User;

@Controller
public class DashboardController {

    @GetMapping({"/dashboard"})
    public String showDashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Check if user is authenticated and not anonymous
        if (authentication != null && authentication.isAuthenticated() && 
            !authentication.getPrincipal().equals("anonymousUser")) {
            User user = (User) authentication.getPrincipal();
            model.addAttribute("user", user);
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        
        return "dashboard";
    }
} 