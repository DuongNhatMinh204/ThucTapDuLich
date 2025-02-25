package com.nminh.thuctapdulich.entity;

import com.nminh.thuctapdulich.enums.TicketClass;

import java.util.List;

// 1-n với tour
public class Flight {
    private Long id ;
    private TicketClass ticketClass;
    private String airlineName;
    private List<Tour> listTour;
    public  Flight() {}

    public Flight(Long id, TicketClass ticketClass, String airlineName, List<Tour> listTour) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
        this.listTour = listTour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<Tour> getListTour() {
        return listTour;
    }

    public void setListTour(List<Tour> listTour) {
        this.listTour = listTour;
    }
}
