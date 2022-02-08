package com.example.booksapi.controller;

import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import com.example.booksapi.repository.BookRepository;
import com.example.booksapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTests {

     private BookController bookcontroller=new BookController();

     @Autowired
     private MockMvc mockMvc;
    @MockBean
    BookService bookservice;

//Test pour enregistrer un livre
    @Test
    public void saveBookTest() throws Exception {

        List<Commentaire> commentaires = new ArrayList<>();
        commentaires.add(new Commentaire(10,"really good reading"));
        Book book1 = new Book(9, "Red Book",commentaires);

        when(bookservice.addBook(book1)).thenReturn(book1);
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Uuid").value(9))
                .andExpect(status().isOk());
    }

}
