package ru.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.stellarburgers.api.dto.AuthResponse;
import ru.stellarburgers.api.dto.User;
import ru.stellarburgers.api.dto.UserCredentials;

import static io.restassured.RestAssured.given;

public class UserApi extends ApiClient {

    @Step("API: register user")
    public AuthResponse register(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/auth/register")
                .then().log().all()
                .extract()
                .as(AuthResponse.class);
    }

    @Step("API: login user")
    public AuthResponse login(UserCredentials creds) {
        return given()
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .as(AuthResponse.class);
    }

    @Step("API: delete user (cleanup)")
    public void delete(String accessToken) {
        if (accessToken == null || accessToken.isBlank()) return;

        // Обычно accessToken приходит как "Bearer xxx"
        String token = accessToken.startsWith("Bearer ") ? accessToken : "Bearer " + accessToken;

        try {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("/auth/user")
                    .then()
                    .extract()
                    .response();
        } catch (Exception ignored) {
            // cleanup не должен валить тесты
        }
    }
}
