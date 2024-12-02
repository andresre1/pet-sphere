package com.project.user.infrastructure.persistence;

import com.project.user.domain.User;
import com.project.user.domain.UserId;
import com.project.user.domain.exception.UserNotFoundException;
import com.project.user.domain.ports.UserQueryPersistencePort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserQueryPersistenceAdapter implements UserQueryPersistencePort {

  private final UserMapper userMapper;

  public UserQueryPersistenceAdapter(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public User findById(UserId userId) {
    UserEntity userEntity =
        (UserEntity)
            UserEntity.findByIdOptional(userId.id())
                .orElseThrow(() -> new UserNotFoundException(userId));
    return userMapper.toDomain(userEntity);
  }
}
