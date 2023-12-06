package com.demp.repository;

import com.demp.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book , UUID> {
    public Book findBookByBookName(String bookName);
}
