package com.example.booksapi.service;

import com.example.booksapi.model.Book;
import com.example.booksapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

     private BookRepository bookrepository;

    public BookServiceImplementation(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookrepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        bookrepository.save(book);
        return book;
    }

    @Override
    public void updateBook(Book book,int id) {
       bookrepository.findById(id)
                .map(b -> {
                    b.setUuid(book.getUuid());
                    b.setName(book.getName());
                    b.setCommentaires(book.getCommentaires());
                   return bookrepository.save(book);
                })
                .orElseGet(() -> {
            book.setUuid(id);
            return bookrepository.save(book);
        });
    }

    @Override
    public void deleteBook(int id) {
        bookrepository.deleteById(id);
    }


}
