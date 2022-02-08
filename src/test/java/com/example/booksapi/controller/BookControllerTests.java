package com.example.booksapi.controller;

import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import com.example.booksapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest
public class BookControllerTests {

     private BookController bookcontroller=new BookController();
    @MockBean BookRepository bookrepository;
    @Test
    void getBooksTest(){

    }
//Test pour enregistrer un livre
    @Test
    public void saveBookTest() {
        List<Commentaire> commentaires = new ArrayList<>();
        commentaires.add(new Commentaire(10,"really good reading"));
        Book book = new Book(9, "Red Book",commentaires);
        when(bookrepository.save(book)).thenReturn(book);
        assertEquals(book, bookcontroller.addBook(book));
    }

}
