package com.project.user.application;

import com.project.user.domain.User;
import com.project.user.domain.UserEmail;
import com.project.user.domain.UserId;
import com.project.user.domain.ports.UserQueryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SearchUseCaseTest {

  private UserQueryPersistencePort mockPersistencePort;
  private SearchUserUseCase searchUserUseCase;

  @BeforeEach
  void setUp() {
    this.mockPersistencePort = mock(UserQueryPersistencePort.class);
    this.searchUserUseCase = new SearchUserUseCase(mockPersistencePort);
  }

  @Test
  void shouldFindUserById() {
    UserId userId = new UserId();
    User expectedUser =
        new User(userId, "Andres", new UserEmail("andres@example.com"), "123456789", null, null);

    when(mockPersistencePort.findById(userId)).thenReturn(expectedUser);

    User actualUser = searchUserUseCase.findById(userId);

    assertEquals(expectedUser, actualUser);
    verify(mockPersistencePort).findById(userId);
  }
}
