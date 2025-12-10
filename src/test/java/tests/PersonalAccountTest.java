package tests;

import config.BaseTest;
import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {

    @Test
    public void goToPersonalAccountAndBackToConstructor() {
        // логин
        LoginPage loginPage = mainPage.clickLoginAccountButton();
        ProfilePage profilePage = loginPage.login(USER_EMAIL, USER_PASSWORD);

        // из личного кабинета возвращаемся в конструктор
        MainPage backToMain = profilePage.clickConstructor();

        String url = backToMain.getCurrentUrl();
        assertTrue(url.contains("stellarburgers"));
    }
}


