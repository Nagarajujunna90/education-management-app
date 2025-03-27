package com.nr.authservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "MySuperSecretKeyForJWTGenerationMySuperSecret"; // Min 32 chars
    private final long ACCESS_TOKEN_EXPIRY = 1 * 60 * 1000; // 15 minutes
   // private final long REFRESH_TOKEN_EXPIRY = 30 * 24 * 60 * 60 * 1000; // 30 days
    private final long REFRESH_TOKEN_EXPIRY = Duration.ofMinutes(50).toMillis();// 15 minutes


    //    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRY ))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRY))
                .signWith(SECRET_KEY)
                .compact();
    }
    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build().parseSignedClaims(token)    // Use parseClaimsJws() instead of parseSignedClaims()
                .getPayload();
    }

   public boolean validateToken(String token) {
        try {
            Jwts.parser()
                 .verifyWith(SECRET_KEY)
                 .build().parseSignedClaims(token).getPayload();
            return true;
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            return false;
        }
    }


//    public boolean validateToken(String token, String username) {
//        return (getClaims(token).equals(username) && !isTokenExpired(token));
//    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }



}
