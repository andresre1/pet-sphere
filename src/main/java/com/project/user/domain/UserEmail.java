package com.project.user.domain;

import org.apache.commons.validator.routines.EmailValidator;

public record UserEmail(String value) {

  public static final EmailValidator VALIDATOR = EmailValidator.getInstance();

  public UserEmail {
    if (!VALIDATOR.isValid(value)) {
      throw new IllegalArgumentException("Invalid email: " + value);
    }
  }
}
