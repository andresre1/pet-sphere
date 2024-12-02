package com.project.user.infrastructure.web.handler;

import static io.quarkus.logging.Log.errorf;

import com.project.user.domain.exception.UserNotFoundException;
import com.project.user.infrastructure.web.ErrorResponse;
import jakarta.ws.rs.core.Response;
import java.util.concurrent.CompletionException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.jboss.resteasy.reactive.server.UnwrapException;

@UnwrapException({CompletionException.class, UserNotFoundException.class})
public class UserNotFoundExceptionHandler {

  @ServerExceptionMapper
  public Response handle(UserNotFoundException e) {
    errorf("IdNotFoundException: %s", e.getMessage(), e);
    var errorMessageDto = new ErrorResponse(e.getError().code(), e.getMessage());
    return Response.status(Response.Status.NOT_FOUND).entity(errorMessageDto).build();
  }
}
