package com.project.user.application;

import com.project.user.domain.User;
import com.project.user.domain.UserId;
import com.project.user.domain.ports.UserQueryPersistencePort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SearchUserUseCase {

  private final UserQueryPersistencePort userQueryPersistencePort;

  public SearchUserUseCase(UserQueryPersistencePort userQueryPersistencePort) {
    this.userQueryPersistencePort = userQueryPersistencePort;
  }

  public User findById(UserId userId) {
    return userQueryPersistencePort.findById(userId);
  }
}
