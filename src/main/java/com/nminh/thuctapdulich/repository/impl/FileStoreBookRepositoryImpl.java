package com.nminh.thuctapdulich.repository.impl;

import com.nminh.thuctapdulich.entity.Book;
import com.nminh.thuctapdulich.repository.FileStoreBookRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FileStoreBookRepositoryImpl implements FileStoreBookRepository {
    private static final String FILE_STORE_BOOK = "book.txt";
    @Override
    public void save(Book book) {
        try(FileWriter fileWriter = new FileWriter(FILE_STORE_BOOK ,true)) {
            fileWriter.write(book.toString());
            fileWriter.write("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // hàm lấy số người đi của 1 chuyến
    public int getNumberOfPeopleBooks(Long id) {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_STORE_BOOK))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data[0].equals(id.toString())) {
                    return Integer.parseInt(data[2]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_STORE_BOOK))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book();
                book.setId(Long.parseLong(data[0]));
                book.setDestination(data[1]);
                book.setNumberOfPeople(Integer.parseInt(data[2]));

                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                try {
                    Date startDate = dateFormat.parse(data[3]);
                    Date endDate = dateFormat.parse(data[4]);
                    book.setStartDate(startDate);
                    book.setEndDate(endDate);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                books.add(book);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findBookById(Long id) {
        List<Book> books = getAllBooks();
        for(Book book : books) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
