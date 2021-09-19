package com.estafet.learning.jdbc.model;

import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private Double price;
    private int categoryID;
    private LocalDateTime createdAt;
    private LocalDateTime lastEditedAt;

    public Product() {
        DataGenerator dataGenerator = new DataGenerator();
        this.name = dataGenerator.getRandomName();
        this.description = dataGenerator.getDescription();
        this.price = dataGenerator.getRandomInt(1, 512) + dataGenerator.getRandomDouble();
        this.categoryID = dataGenerator.getRandomInt(1, 230);
    }

    public Product(int id, String name, String description, Double price, int categoryID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.createdAt = LocalDateTime.now();
        this.lastEditedAt = LocalDateTime.now();
    }
}
