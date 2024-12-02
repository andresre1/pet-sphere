package com.project.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserIdTest {

  @Test
  void shouldThrowExceptionWhenIdIsNull() {
    NullPointerException exception =
        assertThrows(NullPointerException.class, () -> new UserId(null));

    assertEquals("id must not be null", exception.getMessage());
  }
}
