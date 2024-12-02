package com.project.user.domain.exception;

import com.project.user.domain.UserId;

public class UserNotFoundException extends ApplicationException {

  public UserNotFoundException(UserId userId) {
    super(
        ApplicationError.ID_NOT_FOUND,
        String.format(ApplicationError.ID_NOT_FOUND.message(), userId.id().toString()));
  }
}
