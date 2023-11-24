package com.demp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Customer implements User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String username;
    private final String password;
    private final String sex;
    private final String phone;
    private final String address;
    private final int unReturnedNum;

}
