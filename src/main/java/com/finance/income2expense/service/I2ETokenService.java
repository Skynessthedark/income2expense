package com.finance.income2expense.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface I2ETokenService {
    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    long getExpirationTime();

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);

    Date extractExpiration(String token);
}
