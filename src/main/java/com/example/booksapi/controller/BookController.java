package com.example.booksapi.controller;

import com.example.booksapi.model.Book;
import com.example.booksapi.repository.BookRepository;
import com.example.booksapi.service.BookService;
import com.example.booksapi.service.BookServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookservice.getBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookservice.addBook(book);

    }

    @DeleteMapping("/books/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        bookservice.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public String updateEmployee(@RequestBody Book bookupdated, @PathVariable Integer id) {
        bookservice.updateBook(bookupdated, id);
        return "Book Updated";
    }
}