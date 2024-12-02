package com.project.user.infrastructure.persistence;

import com.project.user.domain.User;
import com.project.user.domain.UserEmail;
import com.project.user.domain.UserId;
import com.project.user.domain.UserType;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {

  public User toDomain(UserEntity userEntity) {
    return new User(
        new UserId(userEntity.id),
        userEntity.name,
        new UserEmail(userEntity.email),
        userEntity.phone,
        UserType.valueOf(userEntity.userType),
        userEntity.createdAt);
  }
}
