package com.estafet.learning.api.rest.restUtils;

import com.github.javafaker.Faker;

public class DataGenerator {
    private Faker faker = new Faker();

    public int getRandomInt(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public String name() {
        return faker.funnyName().name();
    }

}
