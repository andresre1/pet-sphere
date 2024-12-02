package com.project.user.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import com.project.user.domain.*;
import com.project.user.domain.exception.UserNotFoundException;
import com.project.user.infrastructure.persistence.UserQueryPersistenceAdapter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserQueryPersistenceAdapterTest {

  @Inject UserQueryPersistenceAdapter mockUserQueryPersistenceAdapter;

  @Test
  void shouldReturnUserWhenIdExists() {
    UUID uuid = UUID.fromString("f52e1eb3-02c5-4910-b167-ddbbb7c640e9");
    var userId = new UserId(uuid);

    var user = mockUserQueryPersistenceAdapter.findById(userId);

    assertNotNull(user);
  }

  @Test
  void shouldThrowWhenIdNotExists() {
    UUID uuid = UUID.fromString("b52e1eb3-02c5-4910-b167-ddbbb7c640e9");
    var userId = new UserId(uuid);

    var exception =
        assertThrows(
            UserNotFoundException.class, () -> mockUserQueryPersistenceAdapter.findById(userId));

    assertEquals(
        "Provided id b52e1eb3-02c5-4910-b167-ddbbb7c640e9 could not be found",
        exception.getMessage());
  }
}
