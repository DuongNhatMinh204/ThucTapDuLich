package com.nminh.thuctapdulich.entity;

import java.util.Date;


public class Tour extends Book {
    private double totalPrice ;
    private Long flightId ;
    private Long hotelId ;
    private Payment payment ;

    public Tour() {}

    public Tour(Long id, String destination, int numberOfPeople, Date startDate, Date endDate, double totalPrice, Long flightId, Long hotelId, Payment payment) {
        super(id, destination, numberOfPeople, startDate, endDate);
        this.totalPrice = totalPrice;
        this.flightId = flightId;
        this.hotelId = hotelId;
        this.payment = payment;
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
