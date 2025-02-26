package com.nminh.thuctapdulich.entity;

import java.util.Date;

public class Book {
    protected Long id ;
    protected String destination ;
    protected int numberOfPeople ;
    protected Date startDate ;
    protected Date endDate ;
    protected Flight flight ;
    public Book() {
    }

    public Book(Long id, String destination, int numberOfPeople, Date startDate, Date endDate) {
        this.id = id;
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Book(Long id, String destination, int numberOfPeople, Date startDate, Date endDate, Flight flight) {
        this.id = id;
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
        this.startDate = startDate;
        this.endDate = endDate;
        this.flight = flight;
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
    public String toString() {
        return id+","+destination+","+numberOfPeople+","+startDate+","+endDate;
    }
}
