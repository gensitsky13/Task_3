package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath(".//a[contains(@href,'/login')]");
    private final By errorText = By.xpath(".//p[contains(@class,'input__error')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Регистрация пользователя.
     *  После успешной регистрации нас кидает на страницу логина, поэтому возвращаем LoginPage.
     */
    public LoginPage register(String name, String email, String password) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    /** Переход по ссылке «Войти». */
    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    /** Текст ошибки под полем пароля (для теста с коротким паролем). */
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }
}

