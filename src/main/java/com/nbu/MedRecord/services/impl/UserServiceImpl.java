package com.nbu.MedRecord.services.impl;

import com.nbu.MedRecord.Models.entity.User;
import com.nbu.MedRecord.repositories.UserRepository;
import com.nbu.MedRecord.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(String username, String password) {
        // Check if a user already exists with the given email
        if (userRepository.findByUsername(username) != null) {
            // A user already exists with this email, return false to indicate registration failed
            return false;
        }

        // Create a new user
        User user = new User();
        user.setUsername(username);

        // Hash the password with jBcrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashedPassword);

        // Save the user to the database
        userRepository.save(user);

        return true; // Return true to indicate registration was successful
    }

    public User login(String username, String password) {
        // Find the user by email
        User user = userRepository.findByUsername(username);

        // Check if the user was found and the password is correct
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }

        // If the user was not found or the password is incorrect, return null
        return null;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        String username = authentication.getName();
        return userRepository.findByUsername(username);
    }

}
