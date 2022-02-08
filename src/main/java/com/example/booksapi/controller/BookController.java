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

@Controller
public class BookController {

    @Autowired
    private BookService bookservice;

    @GetMapping("/books")
        public List<Book> getBooks(){
      return  bookservice.getBooks();
        }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book){
       bookservice.addBook(book);
        return "book added";
    }
    @DeleteMapping("/books/{id}")
    public void deleteStudent(@PathVariable int id)
    {
     bookservice.deleteBook(id);
      }

      @PutMapping("/books/{id}")
public String updateEmployee(@RequestBody Book bookupdated,@PathVariable int id){
     bookservice.updateBook(bookupdated,id);
     return "Book Updated";
    }
}