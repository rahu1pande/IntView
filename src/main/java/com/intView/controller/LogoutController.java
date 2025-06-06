package com.intView.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            // Clear the security context
            SecurityContextHolder.clearContext();
            
            // Invalidate the session
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            
            // Clear any cookies
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        }
        
        redirectAttributes.addFlashAttribute("message", "You have been successfully logged out.");
        return "redirect:/login?logout";
    }
} 