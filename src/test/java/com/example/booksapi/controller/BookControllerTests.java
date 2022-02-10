package com.example.booksapi.controller;

import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import com.example.booksapi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTests {


    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookService bookservice;
    ObjectMapper mapper = new ObjectMapper();

    //Test pour enregistrer un livre

    @Test
    void saveBookTest() throws Exception {
        //given
        List<Commentaire> commentaires = List.of(new Commentaire(10, "really good reading"));

        Book book1 = new Book(9, "Red Book", commentaires);

        when(bookservice.addBook(book1)).thenReturn(book1);
        //when
        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(book1)))

                .andExpect(jsonPath("$.uuid").value(9))
                .andExpect(status().isOk());
    }

    @Test
    void getBooksTest() {
        //given
        /*List<Commentaire> commentaires = List.of(new Commentaire(10, "really good reading"));

        Book book1 = new Book(9, "Red Book", commentaires);

        //given
        List<Commentaire> commentaires2 = List.of(new Commentaire(20, "bad book"));

        Book book2 = new Book(9, "Blue Book", commentaires);*/


    }

}
