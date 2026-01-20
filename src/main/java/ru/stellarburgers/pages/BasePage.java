package ru.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Step("Click: {locator}")
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    @Step("Wait URL contains{part}")
    protected void waitForUrlContains(String part) {
        wait.until(ExpectedConditions.urlContains(part));
    }

    @Step("Type into {locator}")
    protected void type(By locator, String text) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(text);
    }

    @Step("Wait visible: {locator}")
    protected void waitVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Get current URL")
    public String url() {
        return driver.getCurrentUrl();
    }
}