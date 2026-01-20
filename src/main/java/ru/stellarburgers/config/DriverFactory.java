package ru.stellarburgers.config;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    @Step("Create WebDriver for browser: {browser}")
    public static WebDriver create(String browser) {
        String b = browser == null ? "chrome" : browser.toLowerCase();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");

        if ("yandex".equals(b)) {
            if (!Config.YANDEX_DRIVER_PATH.isBlank()) {
                System.setProperty("webdriver.chrome.driver", Config.YANDEX_DRIVER_PATH);
            }
            if (!Config.YANDEX_BINARY_PATH.isBlank()) {
                options.setBinary(Config.YANDEX_BINARY_PATH);
            }
            return new ChromeDriver(options);
        }

        if (!Config.CHROME_DRIVER_PATH.isBlank()) {
            System.setProperty("webdriver.chrome.driver", Config.CHROME_DRIVER_PATH);
        }
        return new ChromeDriver(options);
    }
}

