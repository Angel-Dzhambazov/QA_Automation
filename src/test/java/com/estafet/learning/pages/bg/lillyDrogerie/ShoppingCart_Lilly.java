package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
