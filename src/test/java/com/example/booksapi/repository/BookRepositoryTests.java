package com.example.booksapi.repository;


import com.example.booksapi.model.Book;
import com.example.booksapi.model.Commentaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookrepository;


    //Test pour enregistrer un livre
    @Test
    public void saveBookTest(){
        List<Commentaire> commentaireslivre1=new ArrayList<>();
        Commentaire commentaire1= new Commentaire(10,"Really nice book");
        commentaireslivre1.add(commentaire1);

        Book book=new Book(1,"La boite a merveille",commentaireslivre1);
        bookrepository.save(book);
        assertThat(book.getUuid()).isGreaterThan(0);

    }

    //Test pour retourner les livres existants
    @Test
    public void getBooksTest(){
        List<Book> books= bookrepository.findAll();
        assertThat(books.size()).isGreaterThan(0);
    }
    //Test pour la suppression
    @Test
    public void deleteBookTest(){
        List<Book> books= bookrepository.findAll();

        bookrepository.deleteById(1);
        assertThat(books.size()).isEqualTo(0);
    }
}
