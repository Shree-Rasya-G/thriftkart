package com.thriftkart.thriftkart.controller;

import com.thriftkart.thriftkart.dto.LoginResponse;
import com.thriftkart.thriftkart.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String type) {
        return authService.login(username, password, type);
    }
}
