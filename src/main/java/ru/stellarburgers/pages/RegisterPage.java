package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final By name = By.xpath(".//label[contains(.,'Имя')]/following-sibling::input");
    private final By email = By.xpath(".//label[contains(.,'Email')]/following-sibling::input");
    private final By password = By.xpath(".//input[@type='password']");
    private final By registerButton = By.xpath(".//button[contains(.,'Зарегистрироваться')]");
    private final By loginLink = By.xpath(".//a[contains(.,'Войти')]");

    private final By passwordError = By.xpath(".//p[contains(@class,'input__error') and contains(.,'Некорректный пароль')]");

    public RegisterPage(WebDriver driver) { super(driver); }

    @Step("Register user via UI")
    public LoginPage register(String nameValue, String emailValue, String passwordValue) {
        type(name, nameValue);
        type(email, emailValue);
        type(password, passwordValue);
        click(registerButton);
        return new LoginPage(driver);
    }

    @Step("Go to login from registration form")
    public LoginPage goToLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }

    @Step("Wait password error")
    public void waitPasswordError() {
        waitVisible(passwordError);
    }
}
