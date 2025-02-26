package com.nminh.thuctapdulich.repository.impl;

import com.nminh.thuctapdulich.entity.Flight;
import com.nminh.thuctapdulich.enums.TicketClass;
import com.nminh.thuctapdulich.repository.FileStoreBookRepository;
import com.nminh.thuctapdulich.repository.FileStoreFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileStoreFlightRepositoryImpl implements FileStoreFlightRepository {
    @Autowired
    private FileStoreBookRepository fileStoreBookRepository;
    private static final String FILE_STORE_FLIGHT = "flight.txt" ;
    @Override
    public void save(Flight flight) {
        try(FileWriter writer = new FileWriter(FILE_STORE_FLIGHT,true)) {
            writer.write(flight.toString());
            writer.write("\n");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveList(List<Flight> flights) {
        try(FileWriter writer = new FileWriter(FILE_STORE_FLIGHT,false)) {
            for (Flight flight : flights) {
                writer.write(flight.toString());
                writer.write("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_STORE_FLIGHT))) {
            String line ;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Flight flight = new Flight();
                flight.setId(Long.valueOf(data[0]));
                flight.setTicketClass(TicketClass.valueOf(data[1]));
                flight.setAirlineName(data[2]);
                flight.setPrice(Double.valueOf(data[3]));
                flight.setBook(fileStoreBookRepository.findBookById(Long.valueOf(data[4])));
                flights.add(flight);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    @Override
    public boolean delete(Long id) {
        List<Flight> flights = getAllFlights();
        int check = 0 ;
        for (Flight flight : flights) {
            if (flight.getId().equals(id)) {
                check++ ;
            }
        }
        if(check ==0) return false;
        flights.removeIf(flight -> flight.getId().equals(id)); // dung collection xoa co dieu kien
        saveList(flights);
        return true;
    }
}
