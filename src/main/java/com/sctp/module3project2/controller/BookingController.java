package com.sctp.module3project2.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.entity.Booking;
import com.sctp.module3project2.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

// Joel

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Booking>> getAllBookings() {
        ArrayList<Booking> allBookings = bookingService.getAllBookings();
        return ResponseEntity.ok(allBookings);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking foundBooking = bookingService.getBooking(id);
        return ResponseEntity.ok(foundBooking);
    }

    @PostMapping("")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.saveBooking(booking);
        return ResponseEntity.ok(newBooking);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
