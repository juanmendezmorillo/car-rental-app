package com.brand.es.carrentapp.adapter.in.web.exception;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorMessage> notFoundException(
      NotFoundException ex, WebRequest request) {

    log.error(ex.getMessage());
    return new ResponseEntity<>(
        new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(Boolean.FALSE)
        ), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InternalException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorMessage> internalException(
      InternalException ex, WebRequest request) {

    log.error(ex.getMessage());
    return new ResponseEntity<>(
        new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(Boolean.FALSE)
        ), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
