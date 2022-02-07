package com.example.booksapi.repository;

import com.example.booksapi.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
