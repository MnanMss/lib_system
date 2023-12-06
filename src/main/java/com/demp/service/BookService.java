package com.demp.service;

import com.demp.model.Book;
import com.demp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {
    BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {this.repo = repo;}


    public Book save(Book book) {
        return repo.save(book);
    }

    public Iterable<Book> findAll() {
        return repo.findAll();
    }

    public Book findBookByBookName(String bookName) {
        return repo.findBookByBookName(bookName);
    }

    public void deleteBookById(UUID id) {
        // http://localhost:9090/
        repo.deleteById(id);
    }
}
