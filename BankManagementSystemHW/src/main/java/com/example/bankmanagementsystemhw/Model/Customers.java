package com.example.bankmanagementsystemhw.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {

    // ID , Username , Balance
    private String id;

    private String username;

    private int balence;
}
