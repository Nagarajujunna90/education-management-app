package com.nr.authservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static String SECRET = "sdfsdfksjafdhksahfkshfkshfkshfdkjhsdafkjhsfkj";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        Jwts.parser()
                .verifyWith((SecretKey) SECRET_KEY)
                .build().parseSignedClaims(token).getPayload();

        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) SECRET_KEY)
                .build().parseSignedClaims(token).getPayload();
    }
}
