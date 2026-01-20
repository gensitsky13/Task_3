package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import org.junit.Test;
import ru.stellarburgers.api.UserApi;
import ru.stellarburgers.api.dto.AuthResponse;
import ru.stellarburgers.api.dto.User;
import ru.stellarburgers.base.BaseTest;
import ru.stellarburgers.pages.MainPage;
import ru.stellarburgers.pages.RegisterPage;
import ru.stellarburgers.utils.TestUserFactory;

public class RegistrationTest extends BaseTest {

    private final UserApi userApi = new UserApi();
    private String tokenToDelete; // cleanup

    @Test
    @Description("Успешная регистрация через UI, после теста удаляем пользователя через API")
    public void shouldRegisterSuccessfully() {
        User user = TestUserFactory.randomUser();

        // UI registration
        new MainPage(driver)
                .open()
                .clickLoginMainButton()
                .goToRegister()
                .register(user.name, user.email, user.password);

        // cleanup token: логинимся API и удаляем
        AuthResponse login = userApi.login(new ru.stellarburgers.api.dto.UserCredentials(user.email, user.password));
        tokenToDelete = login.accessToken;
        userApi.delete(tokenToDelete);
    }

    @Test
    @Description("Ошибка для некорректного пароля (меньше 6 символов)")
    public void shouldShowErrorForShortPassword() {
        User user = TestUserFactory.randomUser();

        RegisterPage reg = new MainPage(driver)
                .open()
                .clickLoginMainButton()
                .goToRegister();

        reg.register(user.name, user.email, "12345");
        reg.waitPasswordError();
    }
}

