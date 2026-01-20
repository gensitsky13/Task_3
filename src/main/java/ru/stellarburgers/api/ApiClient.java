package ru.stellarburgers.api;

import io.restassured.RestAssured;
import ru.stellarburgers.config.Config;

public class ApiClient {
    static {
        RestAssured.baseURI = Config.API_URL;
    }
}
