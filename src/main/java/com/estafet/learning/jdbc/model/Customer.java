package com.estafet.learning.jdbc.model;


import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Customer {
    private int id;
    private String name;
    private String address;
    private String website;
    private Double creditLimit;
    private LocalDateTime createdAt;
    private LocalDateTime lastEditedAt;

    public Customer() {
        DataGenerator dataGenerator = new DataGenerator();
        this.name = dataGenerator.getRandomName();
        this.address = dataGenerator.getAddress();
        this.website = dataGenerator.getWebsite();
        this.creditLimit = dataGenerator.getRandomInt(100, 1000) + dataGenerator.getRandomDouble();
    }

    public Customer(int id, String name, String address, String website, Double creditLimit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.website = website;
        this.creditLimit = creditLimit;
        this.createdAt = LocalDateTime.now();
        this.lastEditedAt = LocalDateTime.now();
    }
}
