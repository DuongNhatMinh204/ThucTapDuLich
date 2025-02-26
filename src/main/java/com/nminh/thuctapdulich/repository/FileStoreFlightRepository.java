package com.nminh.thuctapdulich.repository;

import com.nminh.thuctapdulich.entity.Flight;

import java.util.List;

public interface FileStoreFlightRepository {
    public void save(Flight flight);
    public void saveList(List<Flight> flights);
    public List<Flight> getAllFlights();
    public boolean delete(Long id);
}
