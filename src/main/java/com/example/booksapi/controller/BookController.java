package com.example.booksapi.controller;

import com.example.booksapi.model.Book;
import com.example.booksapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository br;

    @GetMapping("/books")
    public List<Book> getBooks(){
        List<Book> livres = new ArrayList<Book>();
        br.findAll().forEach(livre -> livres.add(livre));
        return livres;
    }
@PostMapping("/books")
    public void addBook(Book book){
        br.save(book);
}
    @DeleteMapping("/books/{id}")
    private void deleteStudent(@PathVariable("id") int id)
    {
        br.deleteById(id);    }

}
