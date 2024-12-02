package com.project.user.infrastructure.web;

import com.project.user.application.SearchUserUseCase;
import com.project.user.domain.User;
import com.project.user.domain.UserId;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

  private final SearchUserUseCase searchUserUseCase;

  public UserResource(SearchUserUseCase searchUserUseCase) {
    this.searchUserUseCase = searchUserUseCase;
  }

  @GET
  @Path("/{userId}")
  @Produces(MediaType.APPLICATION_JSON)
  public UserResponse getUserById(@PathParam("userId") String userId) {
    var user = searchUserUseCase.findById(UserId.of(userId));
    return toResponse(user);
  }

  private UserResponse toResponse(User user) {
    return new UserResponse(
        user.userId().id().toString(),
        user.name(),
        user.email().value(),
        user.phone(),
        user.userType().name(),
        user.createdAt());
  }
}
