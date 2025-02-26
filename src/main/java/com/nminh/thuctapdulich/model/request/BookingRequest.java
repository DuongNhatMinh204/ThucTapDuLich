package com.nminh.thuctapdulich.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class BookingRequest {
    @NotBlank(message = "destination must be not blank")
    private String destination ;
    private int numberOfPeople ;
    @NotNull
    private Date startDate ;
    @NotNull
    private Date endDate ;
    public BookingRequest(){}

    public BookingRequest(String destination, int numberOfPeople, Date startDate, Date endDate) {
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
