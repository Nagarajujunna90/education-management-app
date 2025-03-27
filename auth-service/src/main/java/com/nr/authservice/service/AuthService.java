package com.nr.authservice.service;

import com.nr.authservice.dto.AuthResponse;
import com.nr.authservice.dto.RefreshTokenResponse;
import com.nr.authservice.dto.UserResponse;
import com.nr.authservice.model.CustomUser;

public interface AuthService {
    UserResponse registerUser(CustomUser customUser);

    AuthResponse login(CustomUser customUser);

    RefreshTokenResponse refreshAccessToken(String userName);

    AuthResponse getNewAccessToken(String refreshToken);

    Boolean validateToken(String token);

}
