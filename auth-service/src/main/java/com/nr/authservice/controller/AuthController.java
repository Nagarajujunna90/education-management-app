package com.nr.authservice.controller;

import com.nr.authservice.model.CustomUser;
import com.nr.authservice.service.CustomUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private CustomUserService customUserService;


    public AuthController(AuthenticationManager authenticationManager, CustomUserService customUserService) {
        this.authenticationManager = authenticationManager;
        this.customUserService = customUserService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CustomUser customUser) {
        String token = null;
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customUser.getUsername(), customUser.getPassword()));
        if (authenticate.isAuthenticated())
            token = customUserService.getToken(customUser);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomUser> register(@RequestBody CustomUser customUser) {
        CustomUser user = customUserService.registerUser(customUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
       return new ResponseEntity<>(customUserService.validateToken(token), HttpStatus.OK);
    }

}
