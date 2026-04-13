package com.david.authapi.controller;

import com.david.authapi.dto.AuthResponse;
import com.david.authapi.dto.LoginRequest;
import com.david.authapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String token = service.login(request.getUsername(), request.getPassword());
        return new AuthResponse(token);
    }
}
