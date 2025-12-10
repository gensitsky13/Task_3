package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;

    private final By emailField = By.xpath(".//input[@name='name' or @name='email']");
    private final By restoreButton = By.xpath(".//button[text()='Восстановить']");
    private final By loginLink = By.xpath(".//a[contains(@href,'/login')]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void restorePassword(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(restoreButton).click();
    }

    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}

