package com.demp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Admin implements User{

    @Id
    private UUID id;
    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

    @Column(unique = true)
    private final String username;
    private final String password;
}
