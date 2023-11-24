package com.demp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Admin implements User{

    @Id
    private Long id;

    private final String username;
    private final String password;

}
