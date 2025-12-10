package tests;

import config.BaseTest;
import org.junit.Test;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.ProfilePage;
import page.RegisterPage;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    // вход через кнопку «Личный кабинет» в шапке
    @Test
    public void loginFromHeaderPersonalAccount() {
        LoginPage loginPage = mainPage.clickLoginHeaderButton();
        ProfilePage profilePage = loginPage.login(USER_EMAIL, USER_PASSWORD);
        assertNotNull(profilePage);
        assertTrue(profilePage.getCurrentUrl().contains("/account")
                || profilePage.getCurrentUrl().contains("stellarburgers"));
    }

    // вход через форму регистрации -> ссылка «Войти»
    @Test
    public void loginFromRegistrationForm() {
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        RegisterPage registerPage = loginPage.goToRegisterPage();
        LoginPage backToLogin = registerPage.clickLoginLink();
        ProfilePage profilePage = backToLogin.login(USER_EMAIL, USER_PASSWORD);
        assertNotNull(profilePage);
    }

    // вход через форму восстановления пароля
    @Test
    public void loginFromForgotPasswordForm() {
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        ForgotPasswordPage forgotPage = loginPage.clickForgotPasswordLink();
        LoginPage backToLogin = forgotPage.clickLoginLink();
        ProfilePage profilePage = backToLogin.login(USER_EMAIL, USER_PASSWORD);
        assertNotNull(profilePage);
    }
}
