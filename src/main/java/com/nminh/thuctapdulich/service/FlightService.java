package com.nminh.thuctapdulich.service;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.entity.Flight;
import com.nminh.thuctapdulich.model.request.FlightRequest;

import java.util.List;

public interface FlightService {
    public Flight createFlight(FlightRequest flightRequest,Long bookId);
    public List<Flight> getAllFlights();
    public Flight getFlight(String flightId);
    public String deleteFlight(Long flightId);
    public Book getBook(Long bookId);
}
