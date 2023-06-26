package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.Patient;
import com.nbu.MedRecord.Models.entity.User;
import com.nbu.MedRecord.repositories.PatientRepository;
import com.nbu.MedRecord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private PatientRepository patientRepository;

    @Autowired
    public AuthController(UserService userService,PatientRepository patientRepository) {
        this.userService = userService;
        this.patientRepository = patientRepository;

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
    public String registerUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        // TODO: Your registration logic
        boolean success = userService.registerUser(username, password);
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
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        // Fetch the user object here. Make sure it's not null!
        User user = userService.getCurrentUser();

        // Add the user object to the model
        model.addAttribute("user", user);

        return "profile";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Patient> patients = patientRepository.findByIdentificationNumber(query);

        model.addAttribute("patients", patients);
        return "searchResults"; // assuming you have a Thymeleaf template named "searchResults.html"
    }

}

