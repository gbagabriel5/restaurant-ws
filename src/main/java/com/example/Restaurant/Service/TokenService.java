package com.example.Restaurant.Service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String genarateToken(Authentication authentication);

    boolean isTokenValid(String token);

    Integer getIdUser(String token);
}
