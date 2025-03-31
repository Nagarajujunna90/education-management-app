package com.nr.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nr.gateway.config.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthFilter implements GlobalFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (request.getURI().getPath().equals("/auth/login") ||request.getURI().getPath().equals("/auth/register")) {
            return chain.filter(exchange); // Skip token validation for login
        }

        if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            return onError(exchange, "Authorization header missing");
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
        if (!jwtUtil.validateToken(token)) {
            return onError(exchange, "Invalid or expired token");
        }

        return chain.filter(exchange);
    }

    private final ObjectMapper objectMapper = new ObjectMapper(); // JSON Mapper

    private Mono<Void> onError(ServerWebExchange exchange, String errorMessage) {

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);
        errorResponse.put("status", String.valueOf(HttpStatus.UNAUTHORIZED.value()));

        byte[] errorBytes;
        try {
            errorBytes = objectMapper.writeValueAsBytes(errorResponse);
        } catch (Exception e) {
            errorBytes = "{\"error\":\"Internal Server Error\"}".getBytes();
        }

        return exchange.getResponse().writeWith(Mono.just(exchange.getResponse()
                .bufferFactory().wrap(errorBytes)));


    }

}
