package com.project.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
