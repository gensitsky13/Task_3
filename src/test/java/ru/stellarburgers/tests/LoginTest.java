package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.api.UserApi;
import ru.stellarburgers.api.dto.AuthResponse;
import ru.stellarburgers.api.dto.User;
import ru.stellarburgers.api.dto.UserCredentials;
import ru.stellarburgers.base.BaseTest;
import ru.stellarburgers.pages.MainPage;
import ru.stellarburgers.pages.LoginPage;
import ru.stellarburgers.utils.TestUserFactory;

public class LoginTest extends BaseTest {

    private final UserApi userApi = new UserApi();
    private User user;
    private String accessToken;

    @Before
    public void createUser() {
        user = TestUserFactory.randomUser();
        AuthResponse reg = userApi.register(user);
        accessToken = reg.accessToken;
    }

    @After
    public void cleanup() {
        userApi.delete(accessToken);
    }

    @Test
    @Description("Вход по кнопке 'Войти в аккаунт' на главной")
    public void shouldLoginFromMainLoginButton() {
        new MainPage(driver)
                .open()
                .clickLoginMainButton()
                .login(user.email, user.password);
    }

    @Test
    @Description("Вход через кнопку 'Личный кабинет'")
    public void shouldLoginFromPersonalAccountButton() {
        new MainPage(driver)
                .open()
                .goToPersonalAccount()
                .login(user.email, user.password);
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void shouldLoginFromRegisterForm() {
        LoginPage loginPage = new MainPage(driver)
                .open()
                .clickLoginMainButton()
                .goToRegister()
                .goToLogin();

        loginPage.login(user.email, user.password);

    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void shouldLoginFromForgotPasswordForm() {
        LoginPage loginPage = new MainPage(driver)
                .open()
                .clickLoginMainButton()
                .goToForgotPassword()
                .goToLogin();

        loginPage.login(user.email, user.password);
    }
}
