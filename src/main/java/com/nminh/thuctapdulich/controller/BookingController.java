package com.nminh.thuctapdulich.controller;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.model.request.BookingRequest;
import com.nminh.thuctapdulich.model.response.ApiResponse;
import com.nminh.thuctapdulich.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/create")
    public ApiResponse<Book> createBooking(@Valid  @RequestBody BookingRequest bookingRequest) {
        ApiResponse<Book> apiResponse = new ApiResponse<>();
        Book book = bookingService.createBooking(bookingRequest);
        apiResponse.setResult(book);
        apiResponse.setMessage("Booking Created");
        return apiResponse;
    }
}
