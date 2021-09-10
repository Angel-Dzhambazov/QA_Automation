package com.estafet.learning.api.rest.pojos;

import com.estafet.learning.api.rest.restUtils.DataGenerator;
import lombok.Data;

@Data
public class EmployeePojo {
    private String name;
    private int salary;
    private int age;

    public EmployeePojo() {
        DataGenerator dataGenerator = new DataGenerator();
        this.name = dataGenerator.name();
        this.salary = dataGenerator.getRandomInt(100, 9999);
        this.age = dataGenerator.getRandomInt(18, 64);
    }
}
