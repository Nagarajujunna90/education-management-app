package com.nr.gateway.controller;

import com.nr.gateway.config.JwtUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/")
    public String getToken() {
        return jwtUtil.generateToken();
    }

    @GetMapping("/claims/{token}")
    public Claims getClaims(@PathVariable("token") String token) {
        return JwtUtil.getClaims(token);
    }



    @GetMapping("/studentServiceFallback")
    public String studentServiceFailure() {
        return "Student service failure";
    }
}
