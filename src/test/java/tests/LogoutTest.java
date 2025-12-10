package tests;

import config.BaseTest;
import org.junit.Test;
import page.LoginPage;
import page.ProfilePage;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test
    public void userCanLogoutFromProfile() {
        // логин
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        ProfilePage profilePage = loginPage.login(USER_EMAIL, USER_PASSWORD);

        // выходим
        LoginPage backToLogin = profilePage.clickExitButton();

        // проверяем, что мы на странице логина
        String url = backToLogin.getCurrentUrl();
        assertTrue(url.contains("/login"));
    }
}

