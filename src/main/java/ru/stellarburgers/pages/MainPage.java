package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stellarburgers.config.Config;

public class MainPage extends BasePage {

    private final By loginMainButton = By.xpath(".//button[contains(.,'Войти в аккаунт')]");
    private final By personalAccountLink = By.xpath(".//p[contains(.,'Личный Кабинет') or contains(.,'Личный кабинет')]");
    private final By constructorLink = By.xpath(".//p[contains(.,'Конструктор')]");
    private final By logo = By.xpath(".//div[contains(@class,'AppHeader_header__')]//a");

    // Tabs
    private final By bunsTab = By.xpath(".//span[contains(.,'Булки')]/parent::div");
    private final By saucesTab = By.xpath(".//span[contains(.,'Соусы')]/parent::div");
    private final By fillingsTab = By.xpath(".//span[contains(.,'Начинки')]/parent::div");

    // Active tab marker
    private final By activeTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__')]");

    public MainPage(WebDriver driver) { super(driver); }

    @Step("Open main page")
    public MainPage open() {
        driver.get(Config.BASE_URL);
        return this;
    }

    @Step("Click 'Войти в аккаунт' on main")
    public LoginPage clickLoginMainButton() {
        click(loginMainButton);
        return new LoginPage(driver);
    }

    @Step("Go to Personal Account from header")
    public LoginPage goToPersonalAccount() {
        click(personalAccountLink);
        return new LoginPage(driver);
    }

    @Step("Click Constructor in header")
    public MainPage clickConstructor() {
        click(constructorLink);
        return this;
    }

    @Step("Click Stellar Burgers logo")
    public MainPage clickLogo() {
        click(logo);
        return this;
    }
    @Step("Wait for constructor page for load")
    public void waitForConstructorPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
    }

    @Step("Open Buns tab")
    public MainPage openBunsTab() {
        click(bunsTab);
        return this;
    }

    @Step("Wait for ingredients to load")
    public void waitIngredients() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunsTab));
    }

    @Step("Open Sauces tab")
    public MainPage openSaucesTab() {
        click(saucesTab);
        return this;
    }

    @Step("Open Fillings tab")
    public MainPage openFillingsTab() {
        click(fillingsTab);
        return this;
    }

    @Step("Get active tab text")
    public String getActiveTabText() {
        waitVisible(activeTab);
        return driver.findElement(activeTab).getText();
    }
}
