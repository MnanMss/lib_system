package com.demp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class LendRecord {

    @Id
    private UUID id;
    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID();
            renewTime = 3;
        }
    }

    private final String borrowTime;
    private final String returnTime;
    private  int lenDays;

    private int renewTime;

    @Transient
    private int resDays;


    @ManyToOne
    private  Customer customer;
    
    @ManyToOne
    private Book book;
}
