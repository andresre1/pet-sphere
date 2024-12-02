package com.project.user.acceptance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserResourceTestIT {

  @Test
  void shouldReturnUserWhenIdExists() {
    String id = "f52e1eb3-02c5-4910-b167-ddbbb7c640e9";

    given()
        .pathParams("userId", id)
        .when()
        .get("/users/{userId}")
        .then()
        .and()
        .assertThat()
        .statusCode(is(equalTo(200)))
        .body("id", is("f52e1eb3-02c5-4910-b167-ddbbb7c640e9"))
        .body("name", is("John Doe"))
        .body("email", is("john.doe@example.com"))
        .body("phone", is("1234567890"))
        .body("userType", is("PERSONAL"))
        .body("createdAt", is("2024-04-01T11:12:13"));
  }

  @Test
  void shouldThrows_whenUserNotExists() {
    given()
            .pathParams("userId", "b52e1eb3-02c5-4910-b167-ddbbb7c640e9")
            .when()
            .get("/users/{userId}")
            .then()
            .and()
            .assertThat()
            .statusCode(is(equalTo(404)))
            .body("code", is("002"))
            .body("message", is("Provided id b52e1eb3-02c5-4910-b167-ddbbb7c640e9 could not be found"));
  }

  @Test
  void findRevisions_throwRunTimeException_whenIdUUIDIsNotValid() {
    given()
        .pathParams("userId", "123")
        .when()
        .get("/users/{userId}")
        .then()
        .and()
        .assertThat()
        .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .body("code", is("999"))
        .body("message", is("Invalid UUID string: 123"));
  }
}
