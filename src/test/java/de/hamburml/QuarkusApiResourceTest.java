package de.hamburml;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class QuarkusApiResourceTest {

    @Test
    public void testQuarkusApiV1Endpoint() {
        given()
          .when().get("/quarkusapi/v1")
          .then()
             .statusCode(200)
             .body(startsWith("Hello RESTEasy"));
    }

    @Test
    public void testQuarkusApiV2Endpoint() {
        given()
                .when().get("/quarkusapi/v2")
                .then()
                .statusCode(200)
                .body(startsWith("Hello RESTEasy"));
    }

    @Test
    public void QuarkusApiV1AndV2Endpoint_SameContent() {

        var v1Response = given()
                .when().get("/quarkusapi/v1")
                .then()
                .statusCode(200)
                .body(startsWith("Hello RESTEasy"))
                .extract().body().asPrettyString();


        var v2Response = given()
                .when().get("/quarkusapi/v2")
                .then()
                .statusCode(200)
                .body(startsWith("Hello RESTEasy"))
                .extract().body().asPrettyString();

        assertEquals(v1Response, v2Response);
    }

}