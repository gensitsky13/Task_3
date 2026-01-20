package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    private final By logoutButton = By.xpath(".//button[contains(.,'Выход')]");
    private final By profileLink = By.xpath(".//a[contains(.,'Профиль') or contains(.,'Profile')]");

    public ProfilePage(WebDriver driver) { super(driver); }

    @Step("Wait profile page opened")
    public void waitOpened() {
        waitVisible(profileLink);
    }

    @Step("Logout from profile")
    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(driver);
    }
}



