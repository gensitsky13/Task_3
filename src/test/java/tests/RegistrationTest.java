package tests;

import config.BaseTest;
import org.junit.Test;
import page.LoginPage;
import page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    // успешная регистрация
    @Test
    public void successfulRegistration() {
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        RegisterPage registerPage = loginPage.goToRegisterPage();

        String name = "Test User";
        String email = "test+" + System.currentTimeMillis() + "@example.com";
        String password = "123456";

        LoginPage backToLogin = registerPage.register(name, email, password);
        String url = backToLogin.getCurrentUrl();
        assertTrue(url.contains("/login"));
    }

    // ошибка при слишком коротком пароле
    @Test
    public void registrationWithShortPasswordShowsError() {
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        RegisterPage registerPage = loginPage.goToRegisterPage();

        String name = "Test User";
        String email = "test+" + System.currentTimeMillis() + "@example.com";
        String shortPassword = "123";

        registerPage.register(name, email, shortPassword);

        String errorText = registerPage.getErrorText();
        assertTrue(errorText != null && !errorText.isEmpty());
    }
}

