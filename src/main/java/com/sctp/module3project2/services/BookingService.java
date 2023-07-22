package com.sctp.module3project2.services;

import java.util.ArrayList;
import com.sctp.module3project2.entity.Booking;


// Joel 


public interface BookingService {
    
    Booking saveBooking(Booking booking);

    Booking getBooking(Long id);

    ArrayList<Booking> getAllBookings();

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long id);
}
