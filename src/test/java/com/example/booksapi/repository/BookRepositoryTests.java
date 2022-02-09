package com.example.booksapi.repository;


import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class BookRepositoryTests {

    @Autowired
    TestEntityManager testentity;

    @Autowired
    BookRepository bookrepository;


    //Test pour enregistrer un livre
    @Test
    void saveBookTest() {
        //given
        var commentaireslivre1 = List.of(new Commentaire(10, "Really nice book"));

        var book = new Book(1, "La boite a merveilles", commentaireslivre1);
        testentity.persist(book);
        //when
        var book1 = bookrepository.findById(book.getUuid());
        //then
        assertThat(book1).isEqualTo(Optional.of(book));

    }

    //Test pour retourner les livres existants
    @Test
    void getBooksTest() {
        //given
        var commentaires = List.of(new Commentaire(10, "Really nice book"));
        var book = new Book(2, "Le tour du monde en 80 jours", commentaires);
        testentity.persist(book);
        List<Book> books = bookrepository.findAll();
        assertThat(books.size()).isGreaterThan(0);

    }

    //Test pour la suppression
    @Test
    public void deleteBookTest() {
        var commentaires = List.of(new Commentaire(100, "Really nice book"));
        var book1 = new Book(10, "Le tour du monde en 80 jours", commentaires);
        testentity.persist(book1);

        var commentaires2 = List.of(new Commentaire(200, "Not a bad one"));
        var book2 = new Book(20, "Livre 2", commentaires2);
        testentity.persist(book2);

        bookrepository.deleteById(book2.getUuid());
        List<Book> books = bookrepository.findAll();

        assertThat(books.size()).isEqualTo(1);
    }
}
