package com.demp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private final String ISBN;
    private final String bookName;
    private final String author;
    private final String bookCompany;
    private final Double price;
    /**
     * 出版日
     */
    private final Date bookDate;
    private final int totalNumber;
    private final int freeNumber;
}
