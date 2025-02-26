package com.nminh.thuctapdulich.model.request;

public class HotelRequest {
    private String hotelName ;
    private double hotelPrice ;

    public HotelRequest() {
    }

    public HotelRequest(String hotelName, double hotelPrice) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
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
}
