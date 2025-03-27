package com.nr.authservice.service;

import com.nr.authservice.config.JwtUtil;
import com.nr.authservice.dto.AuthResponse;
import com.nr.authservice.dto.RefreshTokenResponse;
import com.nr.authservice.dto.UserResponse;
import com.nr.authservice.model.CustomUser;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AuthServiceImpl implements AuthService {
    private JwtUtil jwtUtil;
    private CustomUserService customUserService;
    private AuthenticationManager authenticationManager;


    public AuthServiceImpl(JwtUtil jwtUtil, CustomUserService customUserService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.customUserService = customUserService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public RefreshTokenResponse refreshAccessToken(String userName) {
        String refreshToken = jwtUtil.generateRefreshToken(userName);
        return new RefreshTokenResponse(jwtUtil.generateRefreshToken(userName), jwtUtil.getClaims(refreshToken).getIssuedAt(), jwtUtil.getClaims(refreshToken).getExpiration());
    }

    @Override
    public UserResponse registerUser(CustomUser customUser) {
        return customUserService.registerUser(customUser);
    }

    @Override
    public AuthResponse login(CustomUser customUser) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customUser.getUsername(), customUser.getPassword()));
        if (authenticate.isAuthenticated()) {
            String accessToken = customUserService.generateToken(customUser.getUsername());
            Date issueDate = jwtUtil.getClaims(accessToken).getIssuedAt();
            Date expiryDate = jwtUtil.getClaims(accessToken).getExpiration();
            return new AuthResponse(accessToken, issueDate, expiryDate);
        }
        return null;
    }

    @Override
    public AuthResponse getNewAccessToken(String refreshToken) {
        try {
            String userName = jwtUtil.getClaims(refreshToken).getSubject();
            if (jwtUtil.validateToken(refreshToken)) {
                String newAccessToken = jwtUtil.generateAccessToken(userName);
                Date issueDate = jwtUtil.getClaims(newAccessToken).getIssuedAt();
                Date expiryDate = jwtUtil.getClaims(newAccessToken).getExpiration();
                return new AuthResponse(newAccessToken, issueDate, expiryDate);
            }
        } catch (JwtException jwtException) {
            throw new JwtException("Invalid token");
        }
        return null;
    }

    @Override
    public Boolean validateToken(String token) {
        return customUserService.validateToken(token);
    }
}
