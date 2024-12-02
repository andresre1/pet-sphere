package com.project.user.domain;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID id) {

  public UserId {
    Objects.requireNonNull(id, "id must not be null");
  }

  public static UserId of(String id) {
    return new UserId(UUID.fromString(id));
  }

  public UserId() {
    this(UUID.randomUUID());
  }
}
