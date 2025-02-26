package com.nminh.thuctapdulich.service.impl;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.model.request.BookingRequest;
import com.nminh.thuctapdulich.repository.FileStoreBookRepository;
import com.nminh.thuctapdulich.repository.impl.ID_Manage;
import com.nminh.thuctapdulich.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private FileStoreBookRepository fileStoreBookRepository;

    public Book createBooking(BookingRequest bookingRequest) {
        Book book = new Book();

        book.setId(ID_Manage.getLastIdBoook()); // lấy id luu trong file
        ID_Manage.saveLastIdBook(ID_Manage.getLastIdBoook()+1); // tăng id trong file lên 1 cho lần tới

        book.setDestination(bookingRequest.getDestination());
        book.setNumberOfPeople(bookingRequest.getNumberOfPeople());
        book.setStartDate(bookingRequest.getStartDate());
        book.setEndDate(bookingRequest.getEndDate());
        fileStoreBookRepository.save(book);

        return book;
    }

    @Override
    public Book findBookingById(Long id) {
        List<Book> books = fileStoreBookRepository.getAllBooks();
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null ;
    }

    @Override
    public List<Book> getAllBookings() {
        return fileStoreBookRepository.getAllBooks() ;
    }

}
