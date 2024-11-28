package com.project.user.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public record User(
    UserId userId,
    String name,
    UserEmail email,
    String phone,
    UserType userType,
    LocalDateTime createdAt) {

  public User(String name, UserEmail email, String phone, UserType userType) {
    this(new UserId(), name, email, phone, userType, LocalDateTime.now());
    Objects.requireNonNull(name, "name must not be null");
    Objects.requireNonNull(phone, "phone must not be null");
  }
}
