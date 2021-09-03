package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sound.midi.Soundbank;

public class ShoppingCart_Lilly {

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div/div[3]/div[2]/div[3]/div/table/tbody/tr[2]/td/strong/span")
    WebElement totalPrice;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div/div[3]/div[2]/ul/li/button")
    WebElement finishOrder;

    private final WebDriver driver;

    public ShoppingCart_Lilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void getTotalPrice() {

        System.out.println(totalPrice.getAttribute("data-bind=\"text: getValue()\""));
    }

    public void finishOrder() {
        finishOrder.click();
    }

    public void deleteAllitems() {
        while (true) {
//            try {
            driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/form/div[1]/div/div[2" +
                    "]/div/div[4]/div/a")).click();
//            } catch () {
//                System.out.println("All items deleted.");
//                break;
//            }
        }
    }

}
