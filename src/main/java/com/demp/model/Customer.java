package com.demp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Customer implements User{
    @Id
    private UUID id;
    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID();
            lendBookNum = 5;
            isLock = false;
        }
    }


    private String authority;
    @Column(unique = true)
    private final String username;
    private final String password;
    private final String phone;
    private final String mail;
    private  int unReturnedNum;
    private  int lendBookNum;

    private boolean isLock;

}
