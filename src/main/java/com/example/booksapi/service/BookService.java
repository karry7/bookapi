package com.example.booksapi.service;

import com.example.booksapi.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book addBook(Book book);
    void updateBook(Book book,int id);
    void deleteBook(int id);
}
