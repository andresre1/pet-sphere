package com.project.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void shouldThrowExceptionWhenNameIsNull() {
    NullPointerException exception =
        assertThrows(
            NullPointerException.class,
            () ->
                new User(null, new UserEmail("andres@gmail.com"), "111222333", UserType.PERSONAL));

    assertEquals("name must not be null", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenPhoneIsNull() {
    NullPointerException exception =
            assertThrows(
                    NullPointerException.class,
                    () ->
                            new User("andres", new UserEmail("andres@gmail.com"), null, UserType.PERSONAL));

    assertEquals("phone must not be null", exception.getMessage());
  }
}
