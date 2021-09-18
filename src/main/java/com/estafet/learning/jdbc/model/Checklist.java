package com.estafet.learning.jdbc.model;

import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

@Data
public class Checklist {
    private String name;
    private Double cost;
    private String initiatedOn;
    private int isCompleted = 0;

    public Checklist() {
        DataGenerator dataGenerator = new DataGenerator();

        this.name = dataGenerator.getDescription();
        this.cost = dataGenerator.getRandomInt(3, 10000) + dataGenerator.getRandomDouble();
        this.initiatedOn = dataGenerator.getRandomDate();
    }
}
