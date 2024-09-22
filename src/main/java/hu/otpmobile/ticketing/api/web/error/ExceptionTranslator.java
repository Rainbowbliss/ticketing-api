package hu.otpmobile.ticketing.api.web.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

  @ExceptionHandler( {HttpClientErrorException.class, HttpStatusCodeException.class, HttpServerErrorException.class})
  @ResponseBody
  public ResponseEntity<Object> httpClientErrorException(HttpStatusCodeException e) {
    ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.status(e.getRawStatusCode()).header("X-Backend-Status", String.valueOf(e.getRawStatusCode()));
    if (e.getResponseHeaders().getContentType() != null) {
      bodyBuilder.contentType(e.getResponseHeaders().getContentType());
    }
    return bodyBuilder.body(e.getResponseBodyAsString());
  }
}
