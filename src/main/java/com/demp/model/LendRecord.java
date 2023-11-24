package com.demp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class LendRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final Date borrowTime;
    private final Date returnTime;
    private final int lenDays;


    @OneToOne
    private  Customer customer;
    
    @OneToOne
    private Book book;
}
