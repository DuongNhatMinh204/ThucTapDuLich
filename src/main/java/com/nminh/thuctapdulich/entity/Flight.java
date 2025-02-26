package com.nminh.thuctapdulich.entity;

import com.nminh.thuctapdulich.enums.TicketClass;

import java.util.List;

// 1-1 với book
public class Flight {
    private Long id ;
    private TicketClass ticketClass;
    private String airlineName;
    private Double price;
    private Book book;
    public  Flight() {}

    public Flight(Long id, TicketClass ticketClass, String airlineName, Double price) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
        this.price = price;
    }

    public Flight(Long id, TicketClass ticketClass, String airlineName, Double price, Book book) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.airlineName = airlineName;
        this.price = price;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id+","+ticketClass+","+airlineName+","+price+","+book.id;
    }
}
