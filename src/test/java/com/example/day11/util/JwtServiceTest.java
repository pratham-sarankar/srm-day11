package com.example.day11.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtServiceTest {
    private final JwtService jwtService = new JwtService();

    @Test
    void shouldGenerateTokenAndExtractUsername() {
        String username = "John";

        String token = jwtService.generateToken(username);
        String extractedUsername = jwtService.extractUsername(token);

        assertEquals(username, extractedUsername);
    }

    @Test
    void shouldReturnTrueWhenTokenIsValid() {
        String username = "john";
        String token = jwtService.generateToken(username);
        boolean isValid = jwtService.isValid(token, username);
        assertTrue(isValid);
    }
}
