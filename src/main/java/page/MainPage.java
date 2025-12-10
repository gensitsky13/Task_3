package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    // кнопка «Войти в аккаунт» на главной
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // «Личный Кабинет» в шапке (для входа)
    private final By personalCabinetButton = By.xpath(".//p[text()='Личный Кабинет']");
    // ссылка «Зарегистрироваться»
    private final By signUpButton = By.xpath(".//a[contains(@href,'/register')]");

    // вкладки конструктора
    private final By bunsTab = By.xpath(".//span[text()='Булки']/..");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']/..");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    // ================== Методы для логина ==================

    // большая кнопка «Войти в аккаунт»
    public LoginPage clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
        return new LoginPage(driver);
    }

    // иногда тесты зовут clickLoginMainButton – просто делегируем
    public LoginPage clickLoginMainButton() {
        return clickLoginAccountButton();
    }

    // «Личный кабинет» в шапке (до логина – открывает страницу логина)
    public LoginPage clickLoginHeaderButton() {
        driver.findElement(personalCabinetButton).click();
        return new LoginPage(driver);
    }

    // «Личный кабинет» после логина – открывает профиль
    public ProfilePage clickPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
        return new ProfilePage(driver);
    }

    // ссылка «Зарегистрироваться»
    public RegisterPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new RegisterPage(driver);
    }

    // ================== Конструктор бургеров ==================

    public void selectBunsTab() {
        driver.findElement(bunsTab).click();
    }

    public void selectSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void selectFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    public boolean isBunsTableActive() {
        WebElement tab = driver.findElement(bunsTab);
        String clazz = tab.getAttribute("class");
        return clazz != null && clazz.contains("current");
    }

    public boolean isSaucesTabActive() {
        WebElement tab = driver.findElement(saucesTab);
        String clazz = tab.getAttribute("class");
        return clazz != null && clazz.contains("current");
    }

    public boolean isFillingsTabActive() {
        WebElement tab = driver.findElement(fillingsTab);
        String clazz = tab.getAttribute("class");
        return clazz != null && clazz.contains("current");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
