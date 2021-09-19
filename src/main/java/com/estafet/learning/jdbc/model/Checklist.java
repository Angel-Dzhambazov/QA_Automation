package com.estafet.learning.jdbc.model;

import com.estafet.learning.jdbc.utils.DataGenerator;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Checklist {
    private int id;
    private String name;
    private Double cost;
    private String initiatedOn;
    private int isCompleted = 0;
    private LocalDateTime createdAt;
    private LocalDateTime lastEditedAt;

    public Checklist() {
        DataGenerator dataGenerator = new DataGenerator();

        this.name = dataGenerator.getDescription();
        this.cost = dataGenerator.getRandomInt(3, 10000) + dataGenerator.getRandomDouble();
        this.initiatedOn = dataGenerator.getRandomDate();
    }

    public Checklist(int id, String name, Double cost, String initiatedOn, int isCompleted) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.initiatedOn = initiatedOn;
        this.isCompleted = isCompleted;
        this.createdAt = LocalDateTime.now();
        this.lastEditedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checklist checklist = (Checklist) o;
        return id == checklist.id && isCompleted == checklist.isCompleted && name.equals(checklist.name) &&
                cost.equals(checklist.cost) && initiatedOn.equals(checklist.initiatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, initiatedOn, isCompleted);
    }
}
