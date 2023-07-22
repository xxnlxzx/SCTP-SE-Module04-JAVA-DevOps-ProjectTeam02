package com.sctp.module3project2.exception;

public class BookingWithDateTimeNotFoundException extends RuntimeException {
  public BookingWithDateTimeNotFoundException(Long id) {
    super("Booking with id " + id + " not found.");
  }
}
