package com.estafet.learning.pages.bg.emag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class TyresPageEmag {

    public final WebDriver driver;

    public TyresPageEmag(WebDriver driver) {
        this.driver = driver;
    }

    public void addRandomTyreToFavourites() {
        int tyreIndex = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        String randomTyreXpath = "//*[@id=\"card_grid\"]/div[" + tyreIndex + "]/div/div/div[2]/button[1]/i";
        driver.findElement(By.xpath(randomTyreXpath)).click();
    }
}
