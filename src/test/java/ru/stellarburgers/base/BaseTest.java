package ru.stellarburgers.base;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.stellarburgers.config.Config;
import ru.stellarburgers.config.DriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @Before
    @Step("Start browser")
    public void setUp() {
        driver = DriverFactory.create(Config.BROWSER);
    }

    @After
    @Step("Quit browser")
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
