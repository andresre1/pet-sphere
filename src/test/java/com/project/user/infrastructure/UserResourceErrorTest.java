package com.project.user.infrastructure;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserResourceErrorTest {

  @Test
  void notFound() {
    given().when().get("/users12345").then().statusCode(HttpStatus.SC_NOT_FOUND).body(is(""));
  }
}
