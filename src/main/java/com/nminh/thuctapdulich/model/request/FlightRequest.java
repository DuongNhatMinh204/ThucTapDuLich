package com.nminh.thuctapdulich.model.request;

import com.nminh.thuctapdulich.enums.TicketClass;

public class FlightRequest {
    private TicketClass ticketClass;
    private String airlineName;

    public FlightRequest(TicketClass ticketClass, String airlineName) {
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
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

}
