package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.entity.Flight;
import com.nminh.thuctapdulich.enums.ErrorCode;
import com.nminh.thuctapdulich.enums.TicketClass;
import com.nminh.thuctapdulich.exception.AppException;
import com.nminh.thuctapdulich.model.request.FlightRequest;
import com.nminh.thuctapdulich.repository.FileStoreBookRepository;
import com.nminh.thuctapdulich.repository.FileStoreFlightRepository;
import com.nminh.thuctapdulich.repository.impl.ID_Manage;
import com.nminh.thuctapdulich.service.BookingService;
import com.nminh.thuctapdulich.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FLightServiceImpl implements FlightService {
    @Autowired
    private FileStoreBookRepository fileStoreBookRepository;

    @Autowired
    private FileStoreFlightRepository fileStoreFlightRepository;

    @Override
    public Flight createFlight(FlightRequest flightRequest,Long bookId) {
        Flight flight = new Flight();

        flight.setId(ID_Manage.getLastIdFlight());
        ID_Manage.saveLastIdFlight(flight.getId()+1);

        flight.setTicketClass(flightRequest.getTicketClass());
        flight.setAirlineName(flightRequest.getAirlineName());

        if(flight.getTicketClass() == TicketClass.BUSINESS_CLASS){
            // lay so nguoi di
            double price = 2000 * fileStoreBookRepository.getNumberOfPeopleBooks(bookId);
            flight.setPrice(price);
        }else  if(flight.getTicketClass() == TicketClass.NORMAL_CLASS){
            double price = 1500 * fileStoreBookRepository.getNumberOfPeopleBooks(bookId);
            flight.setPrice(price);
        }else{
            System.out.println(flight.getTicketClass());
        }


        Book book = fileStoreBookRepository.findBookById(bookId);
        flight.setBook(book);
        fileStoreFlightRepository.save(flight);
        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> listFlights = new ArrayList<>();
        listFlights = fileStoreFlightRepository.getAllFlights() ;
        return listFlights;
    }

    @Override
    public Flight getFlight(String flightId) {
        return null;
    }

    @Override
    public String deleteFlight(Long flightId) {
        if(fileStoreFlightRepository.delete(flightId)){
            return "Flight deleted successfully";
        }
        return "No flight found";
    }

    @Override
    public Book getBook(Long bookId) {
        return fileStoreBookRepository.findBookById(bookId) ;
    }

}
