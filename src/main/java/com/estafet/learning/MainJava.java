package com.estafet.learning;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MainJava {
    private static String dynamicText = "";
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        Faker faker = new Faker();
        Date customDate = faker.date().birthday(0, 1);


        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(customDate);
        System.out.println(date);


    }

    public Date past(int atMost, TimeUnit unit) {
        Date now = new Date();
        Date aBitEarlierThanNow = new Date(now.getTime() - 1000);
        return past(atMost, unit, aBitEarlierThanNow);
    }

    public Date past(int atMost, int minimum, TimeUnit unit) {
        Date now = new Date();
        Date minimumDate = new Date(now.getTime() - unit.toMillis(minimum));
        return past(atMost - minimum, unit, minimumDate);
    }

    public Date past(int atMost, TimeUnit unit, Date referenceDate) {
        long upperBound = unit.toMillis(atMost);

        long futureMillis = referenceDate.getTime();
        futureMillis -= 1 + faker.random().nextLong(upperBound - 1);

        return new Date(futureMillis);
    }

}
