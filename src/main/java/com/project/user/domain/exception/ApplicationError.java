package com.project.user.domain.exception;

public enum ApplicationError {
  UNHANDLED_ERROR("999", null),
  PATH_NOT_FOUND("001", null),
  ID_NOT_FOUND("002", "Provided id %s could not be found");

  private final String code;
  private final String message;

  ApplicationError(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String message() {
    return message;
  }

  public String code() {
    return code;
  }
}
