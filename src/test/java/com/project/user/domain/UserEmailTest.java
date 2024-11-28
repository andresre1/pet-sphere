package com.project.user.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserEmailTest {

  @Test
  void shouldThrowExceptionWhenEmailIsNotValid() {
    String invalidEmail = "andres.sanchez.com";
    String invalidEmail2 = "andressanchez.gamil.com";
    String invalidEmail3 = ".andres.sanchez+test@gamil.com";

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> new UserEmail(invalidEmail));
    IllegalArgumentException exception2 =
        assertThrows(IllegalArgumentException.class, () -> new UserEmail(invalidEmail2));
    IllegalArgumentException exception3 =
        assertThrows(IllegalArgumentException.class, () -> new UserEmail(invalidEmail3));
    IllegalArgumentException exception4 =
        assertThrows(IllegalArgumentException.class, () -> new UserEmail(null));

    assertEquals("Invalid email: " + invalidEmail, exception.getMessage());
    assertEquals("Invalid email: " + invalidEmail2, exception2.getMessage());
    assertEquals("Invalid email: " + invalidEmail3, exception3.getMessage());
    assertEquals("Invalid email: " + null, exception4.getMessage());
  }
}
