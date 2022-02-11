package com.example.booksapi.service;

import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import com.example.booksapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class BookServiceTests {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceImplementation bookService;

    @Test
    void testGetBooks() {
        //given
        var commentaires1 = List.of(new Commentaire(1, "Great Book,i advice people to read it"));

        var book1 = new Book(1, "Black Book", commentaires1);
        var commentaires2 = List.of(new Commentaire(2, "Awful book"));

        var book2 = new Book(1, "Blue Book", commentaires2);

        var books = List.of(book1, book2);

        when(bookRepository.findAll()).thenReturn(books);

        //then
        var truebooks = bookService.getBooks();
        assertThat(books).isEqualTo(truebooks);
    }

    @Test
    void testAddBook() {
        //given
        var commentaires1 = List.of(new Commentaire(1, "Great Book,i advice people to read it"));

        var book1 = new Book(1, "Black Book", commentaires1);
        when(bookRepository.save(book1)).thenReturn(book1);

        //then
        var truebook = bookService.addBook(book1);
        assertThat(book1).isEqualTo(truebook);

    }

    @Test
    void testDeleteBook() {

        //given
        var commentaires1 = List.of(new Commentaire(1, "Great Book,i advice people to read it"));

        var book1 = new Book(1, "Black Book", commentaires1);


        //then

        assertThat(bookService.deleteBook(book1.getUuid())).isEqualTo("Book Deleted");;


    }


}
