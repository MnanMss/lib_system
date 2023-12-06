package com.demp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Book {

    @Id
    private  UUID id;

    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID();
            if(totalNumber != 0) {
                freeNumber = totalNumber;
            }
        }
    }

    @Column(unique = true)
    private final String isbn;

    private final String bookName;
    private  String imgSrc;
    private final String description;
    private final String author;
    private final String bookCompany;
    private final Double price;
    /**
     * 出版日
     */
    private final String publishDate;
    private final int totalNumber;
    private  int freeNumber;

//    public String toString() {
//        return "{[ISBN:" + ISBN + "]," +
//                "[bookName:" + bookName + "]," +
//                "[imgSrc:" + imgSrc + "]," +
//                "[description:" + description + "]," +
//                "[author:" + author + "]," +
//                "[bookCompany:" + bookCompany + "]," +
//                "[price:" + price + "]," +
//                "[publishDate:" + publishDate + "]," +
//                "[totalNumber:" + totalNumber + "]," +
//                "[freeNumber:" + freeNumber + "]}";
//    }
}
