package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By email = By.xpath(".//label[contains(.,'Email')]/following-sibling::input");
    private final By password = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[contains(.,'Войти')]");
    private final By registerLink = By.xpath(".//a[contains(.,'Зарегистрироваться')]");
    private final By forgotPasswordLink = By.xpath(".//a[contains(.,'Восстановить пароль')]");

    public LoginPage(WebDriver driver) { super(driver); }

    @Step("Login with email: {emailValue}")
    public MainPage login(String emailValue, String passwordValue) {
        type(email, emailValue);
        type(password, passwordValue);
        click(loginButton);
        return new MainPage(driver);
    }

    @Step("Wait login page opened")
    public void waitLoginPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Go to registration form from login")
    public RegisterPage goToRegister() {
        click(registerLink);
        return new RegisterPage(driver);
    }

    @Step("Go to forgot password form")
    public ForgotPasswordPage goToForgotPassword() {
        click(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }
}

