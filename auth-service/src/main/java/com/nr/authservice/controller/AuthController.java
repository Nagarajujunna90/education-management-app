package com.nr.authservice.controller;

import com.nr.authservice.dto.UserResponse;
import com.nr.authservice.model.CustomUser;
import com.nr.authservice.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody CustomUser customUser) {
        return ResponseEntity.ok(authService.registerUser(customUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomUser customUser) {
        return ResponseEntity.ok(authService.login(customUser));
    }


    @GetMapping("/refreshToken/{userName}")
    public ResponseEntity<?> refreshAccessToken(@PathVariable("userName") String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.refreshAccessToken(userName));
    }

    @GetMapping("/accessToken")
    public ResponseEntity<?> generateNewToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authService.getNewAccessToken(refreshToken));

    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(authService.validateToken(token));
    }


}
