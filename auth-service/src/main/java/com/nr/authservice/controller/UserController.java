package com.nr.authservice.controller;

import com.nr.authservice.model.CustomUser;
import com.nr.authservice.service.CustomUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
public class UserController {

    private final CustomUserService customUserService;

    public UserController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> getUserIdByUserName(@PathVariable("userName") String userName) {
        try {
            CustomUser user = customUserService.getUserIdByUserName(userName);
            if (user != null) {
                return ResponseEntity.ok(user.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (io.jsonwebtoken.ExpiredJwtException exception) {
            return ResponseEntity.status(401).body("Token expired. Please log in again.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}
