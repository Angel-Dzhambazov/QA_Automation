package com.estafet.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcitePage {
    private static WebElement element = null;

    public static WebElement acceptCookies(WebDriver driver) {
        String yesButton = "/html/body/div[1]/div[2]/div[4]/div[2]/div";
        return driver.findElement(By.xpath(yesButton));
//        return driver.findElement(By.linkText("Yes"));
    }
}
