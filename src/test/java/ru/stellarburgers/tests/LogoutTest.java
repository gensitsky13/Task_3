package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.api.UserApi;
import ru.stellarburgers.api.dto.AuthResponse;
import ru.stellarburgers.api.dto.User;
import ru.stellarburgers.base.BaseTest;
import ru.stellarburgers.pages.LoginPage;
import ru.stellarburgers.pages.MainPage;
import ru.stellarburgers.pages.ProfilePage;
import ru.stellarburgers.utils.TestUserFactory;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

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
    @Description("Выход из аккаунта по кнопке 'Выйти' в ЛК")
    public void shouldLogoutFromProfile() {
        new MainPage(driver)
                .open()
                .goToPersonalAccount()
                .login(user.email, user.password);

        new MainPage(driver).goToPersonalAccount();
        ProfilePage profile = new ProfilePage(driver);
        profile.waitOpened();
        profile.logout();
LoginPage loginPage = new LoginPage(driver);
loginPage.waitLoginPageOpened();
loginPage.waitLoginPageOpened();
        // После логаута обычно возвращает на страницу логина
        assertTrue(new MainPage(driver).url().contains("/login"));
    }
}

