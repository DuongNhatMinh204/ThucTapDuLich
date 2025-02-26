package com.nminh.thuctapdulich.controller;

import com.nminh.thuctapdulich.entity.Flight;
import com.nminh.thuctapdulich.model.request.FlightRequest;
import com.nminh.thuctapdulich.model.response.ApiResponse;
import com.nminh.thuctapdulich.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/createFlight")
    public ApiResponse<Flight> createFlight(@RequestBody FlightRequest flightRequest , @RequestParam Long bookingId) {
        ApiResponse<Flight> apiResponse = new ApiResponse<>();
        apiResponse.setResult(flightService.createFlight(flightRequest ,bookingId));
        apiResponse.setMessage("Flight created");
        return apiResponse;
    }

    @GetMapping("/allFlight")
    public ApiResponse<List<Flight>> getAllFlights(){
        ApiResponse<List<Flight>> apiResponse = new ApiResponse<>();
        List<Flight> listFlight = flightService.getAllFlights();
        apiResponse.setResult(listFlight);
        apiResponse.setMessage("Flight list");
        return apiResponse;
    }
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteFlight(@PathVariable Long id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult(flightService.deleteFlight(id));
        return apiResponse;
    }
}
