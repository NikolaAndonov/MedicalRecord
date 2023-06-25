package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.User;
import com.nbu.MedRecord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        // TODO: Your registration logic
        boolean success = userService.registerUser(email, password);
        if (!success) {
            // registration failed
            redirectAttributes.addFlashAttribute("message", "Registration failed. Please try again.");
            return "redirect:/auth/register";
        }
        // registration was successful, redirect to login
        return "redirect:/auth/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        // TODO: Your login logic
        User user = userService.login(username, password);
        if (user == null) {
            // login failed
            redirectAttributes.addFlashAttribute("message", "Login failed. Please try again.");
            return "redirect:/auth/login";
        }
        // login was successful, redirect to home
        return "redirect:/";
    }

}

