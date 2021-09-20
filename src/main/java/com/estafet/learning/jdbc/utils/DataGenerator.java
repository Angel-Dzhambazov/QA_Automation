package com.estafet.learning.jdbc.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenerator {

    private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    private Faker faker = new Faker();

    public int getRandomInt(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public String getRandomName() {
        return faker.funnyName().name();
    }

    public String getDescription() {
        return faker.harryPotter().spell();
    }

    public Double getRandomDouble() {

        double result = faker.random().nextDouble();

        return result < 0.0 ? result * -1 : result;
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getWebsite() {
        return faker.internet().url();
    }

    public String getRandomDate() {
        Date customDate = faker.date().birthday(0, 1); // Task created in the last year
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
        return simpleDateFormat.format(customDate);
    }
}
