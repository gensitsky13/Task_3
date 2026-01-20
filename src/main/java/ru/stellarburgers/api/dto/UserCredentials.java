package ru.stellarburgers.api.dto;

public class UserCredentials {
    public String email;
    public String password;

    public UserCredentials() { }

    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
