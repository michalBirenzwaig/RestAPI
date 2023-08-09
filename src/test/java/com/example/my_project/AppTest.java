package com.example.my_project;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import javax.xml.ws.Response;

public class EmployeeApiTest {
    private static final String BASE_URL = "https://dummy.restapiexample.com/api/v1";

    @Test
    public void testCreateNewEmployee() {
        String requestBody = "{\"name\":\"Michal\",\"salary\":\"50800\",\"age\":\"30\"}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/create")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("status"), "success");
        assertEquals(response.jsonPath().getString("data.name"), "Michal");
        assertEquals(response.jsonPath().getString("data.salary"), "50800");
        assertEquals(response.jsonPath().getString("data.age"), "30");
        assertNotNull(response.jsonPath().getString("data.id"));
        assertEquals(response.jsonPath().getString("data.profile_image"), "");
        assertEquals(response.jsonPath().getString("message"), "Successfully! Record has been added.");

    }
}
