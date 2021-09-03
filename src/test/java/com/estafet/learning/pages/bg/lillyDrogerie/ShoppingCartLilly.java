package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartLilly {

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]/a/span[3]/span")
    WebElement totalPrice;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div/div[3]/div[2]/ul/li/button")
    WebElement finishOrder;

    private final WebDriver driver;

    public ShoppingCartLilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void finishOrder() {
        finishOrder.click();
    }

    public void deleteAllitems() {
        while (true) {
            try {
                driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/form/div[1]/div/div[2" +
                        "]/div/div[4]/div/a")).click();
            } catch (NoSuchElementException e) {
                break;
            }
        }
    }
}
