package com.nminh.thuctapdulich.entity;

import java.util.Date;
import java.util.List;

public class Tour {
    private Long id ;
    private String destination ;
    private int numberOfPeople ;
    private Date startDate ;
    private Date endDate ;
    private double totalPrice ;
    private Long flightId ;
    private Long hotelId ;
    private Payment payment ;

    public Tour() {}

    public Tour(Long id, String destination, int numberOfPeople, Date startDate, Date endDate, double totalPrice, Long flightId, Long hotelId, Payment payment) {
        this.id = id;
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.flightId = flightId;
        this.hotelId = hotelId;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
