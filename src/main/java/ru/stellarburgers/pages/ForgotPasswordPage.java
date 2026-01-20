package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private final By loginLink = By.xpath(".//a[contains(.,'Войти')]");

    public ForgotPasswordPage(WebDriver driver) { super(driver); }

    @Step("Go to login from forgot password form")
    public LoginPage goToLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }
}


