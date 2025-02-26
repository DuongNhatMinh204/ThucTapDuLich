package com.nminh.thuctapdulich.repository;

import com.nminh.thuctapdulich.entity.Book;

import java.util.List;

public interface FileStoreBookRepository {
    public void save(Book book);
    public int getNumberOfPeopleBooks(Long id);
    public List<Book> getAllBooks();
    public Book findBookById(Long id);
}
