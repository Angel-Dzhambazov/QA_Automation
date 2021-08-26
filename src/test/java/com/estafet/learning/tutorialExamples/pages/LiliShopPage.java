package com.estafet.learning.tutorialExamples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiliShopPage {

    /**
     * finds buttom to accept cookies
     * @param driver
     * @return returns this webElement
     */
    public static WebElement acceptCookies(WebDriver driver){
        String linkText = "Разбрах";
        return driver.findElement(By.linkText(linkText));
    }
}
