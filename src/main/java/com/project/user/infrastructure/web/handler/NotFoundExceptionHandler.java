package com.project.user.infrastructure.web.handler;

import static io.quarkus.logging.Log.errorf;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import java.util.concurrent.CompletionException;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import org.jboss.resteasy.reactive.server.UnwrapException;

@UnwrapException({CompletionException.class, NotFoundException.class})
public class NotFoundExceptionHandler {

  @ServerExceptionMapper
  public Response toResponse(NotFoundException e) {
    errorf("NotFoundException: %s", e.getMessage(), e);
    return Response.status(Response.Status.NOT_FOUND).build();
  }
}
