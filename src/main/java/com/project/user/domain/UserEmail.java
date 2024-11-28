package com.project.user.domain;

import org.apache.commons.validator.routines.EmailValidator;

public record UserEmail(String email) {

  public static final EmailValidator VALIDATOR = EmailValidator.getInstance();

  public UserEmail {
    if (!VALIDATOR.isValid(email)) {
      throw new IllegalArgumentException("Invalid email: " + email);
    }
  }
}
