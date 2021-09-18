package com.estafet.learning.jdbc.model;

import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

@Data
public class Product {
    private String name;
    private String description;
    private Double price;
    private int categoryID;

    public Product() {
        DataGenerator dataGenerator = new DataGenerator();
        this.name = dataGenerator.getRandomName();
        this.description = dataGenerator.getDescription();
        this.price = dataGenerator.getRandomInt(1, 512) + dataGenerator.getRandomDouble();
        this.categoryID = dataGenerator.getRandomInt(1, 230);
    }
}
