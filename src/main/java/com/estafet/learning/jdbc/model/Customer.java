package com.estafet.learning.jdbc.model;


import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

@Data
public class Customer {
    private String name;
    private String address;
    private String website;
    private Double creditLimit;

    public Customer() {
        DataGenerator dataGenerator = new DataGenerator();
        this.name = dataGenerator.getRandomName();
        this.address = dataGenerator.getAddress();
        this.website = dataGenerator.getWebsite();
        this.creditLimit = dataGenerator.getRandomInt(100, 1000) + dataGenerator.getRandomDouble();
    }
}
