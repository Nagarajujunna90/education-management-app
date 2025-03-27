package com.nr.authservice.dto;

import java.util.Date;

public record AuthResponse(
        String accessToken,
        Date issuedAt,
        Date expiresIn
) {}
