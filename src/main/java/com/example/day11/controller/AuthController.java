package com.example.day11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11.util.JwtService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;

    @PostMapping("/auth/login")
    public String login(@RequestParam String username,
            @RequestParam String password) {

        // Normally validate from DB
        if (username.equals("user") && password.equals("password")) {
            return jwtService.generateToken(username);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
