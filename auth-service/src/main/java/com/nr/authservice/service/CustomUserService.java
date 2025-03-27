package com.nr.authservice.service;

import com.nr.authservice.config.JwtUtil;
import com.nr.authservice.dto.UserResponse;
import com.nr.authservice.exception.UserNotFoundException;
import com.nr.authservice.model.CustomUser;
import com.nr.authservice.repo.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomUserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public CustomUserService(UserRepo userRepo, @Lazy PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        CustomUser customUser = userRepo.findByUserName(username).orElseThrow(() -> new UserNotFoundException("User not found: " + username));
        return new User(
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.getRole() != null ?
                        Stream.of(customUser.getRole()).map(SimpleGrantedAuthority::new).collect(Collectors.toList()) :
                        Collections.emptyList()
        );
    }

    public UserResponse registerUser(CustomUser customUser) {
        UserResponse userResponse = new UserResponse();
        customUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
        CustomUser createdUser;
        try {
            createdUser = userRepo.save(customUser);
            userResponse.setUserName(createdUser.getUsername());
            userResponse.setRole(createdUser.getRole());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Username already exists!");
        }
        return userResponse;
    }

    public String generateToken(String userName) {
        UserDetails userDetails = loadUserByUsername(userName);
        return jwtUtil.generateAccessToken(userDetails.getUsername());
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    public CustomUser getUserIdByUserName(String username) {
        return userRepo.findByUserName(username)
                .orElseThrow(() -> new UserNotFoundException("User details not found,please register first, then try again"));
    }
}
