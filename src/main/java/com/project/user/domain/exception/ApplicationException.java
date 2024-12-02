package com.project.user.domain.exception;

public class ApplicationException extends RuntimeException {

  private final ApplicationError error;

  public ApplicationException(ApplicationError error, String message) {
    super(message);
    this.error = error;
  }

  public ApplicationError getError() {
    return error;
  }
}
