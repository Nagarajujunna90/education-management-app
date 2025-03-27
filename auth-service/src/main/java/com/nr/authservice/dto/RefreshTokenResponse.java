package com.nr.authservice.dto;

import java.util.Date;

public record RefreshTokenResponse(
        String refreshToken,
        Date issuedAt,
        Date expiresIn
) {}
