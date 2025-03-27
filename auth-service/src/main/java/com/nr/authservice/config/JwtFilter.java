package com.nr.authservice.config;

import com.nr.authservice.service.CustomUserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    CustomUserService customUserService;

    JwtUtil jwtUtil;

    public JwtFilter(@Lazy CustomUserService customUserService, JwtUtil jwtUtil) {
        this.customUserService = customUserService;
        this.jwtUtil = jwtUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        // Skip token validation for refreshToken API
        if (requestURI.startsWith("/auth/refreshToken") || requestURI.startsWith("/auth/accessToken")||requestURI.startsWith("/swagger-ui")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authentication = request.getHeader("Authorization");
        try {
            if (authentication != null) {
                String token = authentication.substring(7);
                boolean validateToken = jwtUtil.validateToken(token);
                if (validateToken) {
                    Claims claims = jwtUtil.getClaims(token);
                    UserDetails userDetails = customUserService.loadUserByUsername(claims.getSubject());
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }

            }
            filterChain.doFilter(request, response);
        } catch (io.jsonwebtoken.ExpiredJwtException exception) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Token expired\", \"status\": 401}");
        }
    }
}
