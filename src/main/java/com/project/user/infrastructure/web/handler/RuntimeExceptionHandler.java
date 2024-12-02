package com.project.user.infrastructure.web.handler;

import static io.quarkus.logging.Log.errorf;

import com.project.user.domain.exception.ApplicationError;
import com.project.user.infrastructure.web.ErrorResponse;
import jakarta.ws.rs.core.Response;
import java.util.concurrent.CompletionException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.jboss.resteasy.reactive.server.UnwrapException;

@UnwrapException({CompletionException.class, RuntimeException.class})
public class RuntimeExceptionHandler {

  @ServerExceptionMapper
  public Response handle(RuntimeException e) {
    errorf("RuntimeException: %s", e.getMessage(), e);
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(new ErrorResponse(ApplicationError.UNHANDLED_ERROR.code(), e.getMessage()))
        .build();
  }
}
