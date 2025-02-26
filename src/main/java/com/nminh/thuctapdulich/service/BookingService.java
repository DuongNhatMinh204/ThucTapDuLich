package com.nminh.thuctapdulich.service;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.model.request.BookingRequest;

import java.util.List;

public interface BookingService {
    public Book createBooking(BookingRequest bookingRequest);
    public Book findBookingById(Long id);
    public List<Book> getAllBookings();
}
