package com.example.booksapi;

import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import com.example.booksapi.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BooksApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void savingBookWorksThroughAllTheLayers() throws Exception {
		//given
		List<Commentaire> commentaires= List.of(new Commentaire(1,"Good Book"));
         Book book = new Book(1,"First Book",commentaires);
		 //then
    	mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book)))
				.andExpect(status().isOk());
    }

}
