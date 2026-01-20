package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.api.UserApi;
import ru.stellarburgers.api.dto.AuthResponse;
import ru.stellarburgers.api.dto.User;
import ru.stellarburgers.base.BaseTest;
import ru.stellarburgers.pages.MainPage;
import ru.stellarburgers.pages.ProfilePage;
import ru.stellarburgers.utils.TestUserFactory;

import static org.junit.Assert.assertTrue;

public class AccountNavigationTest extends BaseTest {

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
    @Description("Переход в личный кабинет по клику на 'Личный кабинет'")
    public void shouldOpenPersonalAccount() {
        new MainPage(driver)
                .open()
                .goToPersonalAccount()
                .login(user.email, user.password);

        // Снова кликаем ЛК, проверяем что мы в профиле
        new MainPage(driver).goToPersonalAccount();
        ProfilePage profile = new ProfilePage(driver);
        profile.waitOpened();
    }

    @Test
    @Description("Переход из ЛК в конструктор по клику на 'Конструктор' и на логотип")
    public void shouldGoFromProfileToConstructorByConstructorAndLogo() {
        new MainPage(driver)
                .open()
                .goToPersonalAccount()
                .login(user.email, user.password);

        // Открыли профиль
        new MainPage(driver).goToPersonalAccount();
        new ProfilePage(driver).waitOpened();

        // В конструктор по кнопке "Конструктор"
        new MainPage(driver).clickConstructor();
        assertTrue(new MainPage(driver).url().contains("/"));

        // В конструктор по логотипу
        new MainPage(driver).goToPersonalAccount();
        new ProfilePage(driver).waitOpened();
        new MainPage(driver).clickLogo();
        assertTrue(new MainPage(driver).url().contains("/"));
    }
}

