package com.nminh.thuctapdulich.entity;

import java.util.List;
// 1-n với tour
public class Hotel {
    private Long id ;
    private String hotelName ;
    private double hotelPrice ;
    private List<Tour> listTours ;
    public Hotel() {}
    public Hotel(Long id, String hotelName, double hotelPrice, List<Tour> listTours) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.listTours = listTours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public List<Tour> getListTours() {
        return listTours;
    }

    public void setListTours(List<Tour> listTours) {
        this.listTours = listTours;
    }
}
