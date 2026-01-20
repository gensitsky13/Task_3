package ru.stellarburgers.api.dto;

public class AuthResponse {
    public boolean success;
    public User user;
    public String accessToken;
    public String refreshToken;
}
