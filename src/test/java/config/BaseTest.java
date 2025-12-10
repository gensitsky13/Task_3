package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    protected WebDriver driver;

    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        // WebDriverManager сам скачает и пропишет путь к chromedriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // эти аргументы полезны для запуска в CI/через Maven
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // если нужно без открытия окна браузера, можно добавить:
        // options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}