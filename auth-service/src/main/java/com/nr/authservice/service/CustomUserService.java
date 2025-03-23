package com.nr.authservice.service;

import com.nr.authservice.config.JwtUtil;
import com.nr.authservice.exception.UserNotFoundException;
import com.nr.authservice.model.CustomUser;
import com.nr.authservice.repo.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = userRepo.findByUserName(username).orElseThrow(() -> new UserNotFoundException("User not found: " + username));


        return new User(
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.getRole() != null ?
                        customUser.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()) :
                        Collections.emptyList()
        );
    }

    public CustomUser registerUser(CustomUser customUser) {
        customUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
        return userRepo.save(customUser);
    }

    public String getToken(CustomUser customUser) {
        UserDetails userDetails = loadUserByUsername(customUser.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}
