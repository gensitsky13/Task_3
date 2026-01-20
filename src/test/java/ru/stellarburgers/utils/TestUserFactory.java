package ru.stellarburgers.utils;

import ru.stellarburgers.api.dto.User;

import java.util.UUID;

public class TestUserFactory {
    public static User randomUser() {
        String id = UUID.randomUUID().toString().substring(0, 8);
        return new User("olga_" + id + "@test.ru", "123456", "Olga " + id);
    }
}
