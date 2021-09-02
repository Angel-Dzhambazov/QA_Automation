package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShowerGels_Lilly {

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[1]/div/div[4]/select")
    WebElement btn_sortBy;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[1]/div/div[4]/select/option[5]")
    WebElement btn_price_a;

    @FindAll({
//            @FindBy(css = "li[class=\"item product product-item\"]")
            @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[2]/ol/li")
    })
    public List<WebElement> showerGels;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[2]/ol/li[1]/div/div/div[1]/span[1]/span/span[2]")
    WebElement firstShowerGel;


    public ShowerGels_Lilly(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sortByPriceA() {
        btn_sortBy.click();
        btn_price_a.click();
    }

    public void printAllElements() {
        int counter = 0;
        System.out.println("      System.out.println(firstShowerGel.getAttribute(\"data-price-amount\"));");
        System.out.println(firstShowerGel.getAttribute("data-price-amount"));
        for (WebElement showerGel : showerGels) {
            System.out.println(++counter);
//            System.out.println(showerGel.findElement(By.id("product-price-27201")).getAttribute("data-price-amount"));


//            System.out.println(showerGel.getTagName());
//            System.out.println(showerGel.findElements(By.className("price")).toString());
//            System.out.println(showerGel.getAttribute("item product product-item"));
        }
        System.out.println("showerGels.size() = " + showerGels.size());
    }

}
