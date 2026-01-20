package ru.stellarburgers.config;

public class Config {
    // База для UI
    public static final String BASE_URL = System.getProperty("baseUrl", "https://stellarburgers.education-services.ru");
    // База для API
    public static final String API_URL = System.getProperty("apiUrl", BASE_URL + "/api");

    // browser=chrome | yandex
    public static final String BROWSER = System.getProperty("browser", "chrome");

    // Пути к драйверам (задай в системе или как env/idea run config)
    public static final String CHROME_DRIVER_PATH = System.getProperty("chromeDriverPath", "");
    public static final String YANDEX_DRIVER_PATH = System.getProperty("yandexDriverPath", "");
    public static final String YANDEX_BINARY_PATH = System.getProperty("yandexBinaryPath", ""); // опционально
}

