package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    // поля формы логина
    private final By emailField = By.xpath(".//input[@name='name' or @name='email']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    // ссылки под формой
    private final By registerLink = By.xpath(".//a[contains(@href,'/register')]");
    private final By forgotPasswordLink = By.xpath(".//a[contains(@href,'/forgot-password')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================== ПОЛНЫЙ ЛОГИН ==================

    /** Полный логин: вводим email и пароль, жмём «Войти».
     *  Тесты ожидают, что логин вернёт ProfilePage.
     */
    public ProfilePage login(String email, String password) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProfilePage(driver);
    }

    // ================== НЕПОЛНЫЙ ЛОГИН (для негативных тестов) ==================

    /** Ввод только email (без пароля, без отправки формы). */
    public LoginPage enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    /** Ввод только пароля (без email, без отправки формы). */
    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    /** Нажать «Войти», но остаться на странице логина (ожидаем ошибку). */
    public LoginPage clickLoginButtonWithoutRedirect() {
        driver.findElement(loginButton).click();
        return this;
    }

    // ================== ПЕРЕХОДЫ ПО ССЫЛКАМ ==================

    /** Переход по ссылке «Зарегистрироваться». */
    public RegisterPage goToRegisterPage() {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }

    /** Переход по ссылке «Восстановить пароль». */
    public ForgotPasswordPage clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }

    // ================== ВСПОМОГАТЕЛЬНОЕ ==================

    /** Текущий URL страницы (для проверок в тестах). */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

