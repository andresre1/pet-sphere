package com.project.user.infrastructure;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import com.project.user.application.SearchUserUseCase;
import com.project.user.domain.*;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import java.time.LocalDateTime;
import java.time.Month;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserResourceTest {

  @InjectMock SearchUserUseCase mockSearchUserUseCase;

  @Test
  void shouldReturnUserWhenIdExists() {
    String id = "f52e1eb3-02c5-4910-b167-ddbbb7c640e9";

    when(mockSearchUserUseCase.findById(any()))
        .thenReturn(
            new User(
                UserId.of(id),
                "andres",
                new UserEmail("andres@test.com"),
                "123456789",
                UserType.PERSONAL,
                LocalDateTime.of(2024, Month.FEBRUARY, 1, 1, 2, 3)));

    given()
        .pathParams("userId", id)
        .when()
        .get("/users/{userId}")
        .then()
        .and()
        .assertThat()
        .statusCode(is(equalTo(200)))
        .body("id", is(id))
        .body("name", is("andres"))
        .body("email", is("andres@test.com"))
        .body("phone", is("123456789"))
        .body("userType", is("PERSONAL"))
        .body("createdAt", is("2024-02-01T01:02:03"));

    verify(mockSearchUserUseCase).findById(UserId.of("f52e1eb3-02c5-4910-b167-ddbbb7c640e9"));
  }

  @Test
  void findRevisions_throwRunTimeException() {
    when(mockSearchUserUseCase.findById(any()))
        .thenThrow(new RuntimeException("controlled exception"));

    given()
        .pathParams("userId", "f52e1eb3-02c5-4910-b167-ddbbb7c640e9")
        .when()
        .get("/users/{userId}")
        .then()
        .and()
        .assertThat()
        .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .body("code", is("999"))
        .body("message", is("controlled exception"));
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

    verify(mockSearchUserUseCase, never()).findById(any());
  }
}
