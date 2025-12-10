package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;

    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickExitButton() {
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }

    public MainPage clickConstructor() {
        driver.findElement(constructorLink).click();
        return new MainPage(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


