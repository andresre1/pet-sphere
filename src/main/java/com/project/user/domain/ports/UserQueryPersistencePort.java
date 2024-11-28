package com.project.user.domain.ports;

import com.project.user.domain.User;
import com.project.user.domain.UserId;

public interface UserQueryPersistencePort {
  User findById(UserId userId);
}
