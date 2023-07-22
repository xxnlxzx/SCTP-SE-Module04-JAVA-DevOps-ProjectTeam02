package com.sctp.module3project2.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  
  // HANDLE ALL OTHER EXCEPTIONS
  // General exception handler - handle any uncaught exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex) {

    // ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    ErrorResponse errorResponse = new ErrorResponse("Something went wrong. Please try again later.");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Handler for BookingWithDateTimeNotFound exception
   @ExceptionHandler(BookingWithDateTimeNotFoundException.class)
  public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {

    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

   // HANDLE UNSUCCESSFUL DELETION
  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
    ErrorResponse errorResponse = new ErrorResponse("Cannot delete item that doesn't exist.");
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
