package com.example.my_project;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {
    private static final String BASE_URL = "https://dummy.restapiexample.com/api/v1";

    @Test
    public void testCreateNewEmployee() {
        String requestBody = "{\"name\":\"John Doe\",\"salary\":\"50000\",\"age\":\"30\"}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/create")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("data.name", equalTo("John Doe"))
                .body("data.salary", equalTo("50000"))
                .body("data.age", equalTo("30"))
                .body("data.id", not(empty()))
                .body("data.profile_image", isEmptyOrNullString())
                .body("data.message", equalTo("Successfully! Record has been added."));
    }
}
