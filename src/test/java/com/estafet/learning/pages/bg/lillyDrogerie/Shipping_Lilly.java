package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping_Lilly {

    @FindBy(name = "telephone")
    WebElement txt_telephone;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/div/label[2]")
    WebElement btn_radioDeliveryAddress;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[6]/div/span/span[1]/span")
    WebElement btn_TownDropDown;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement txt_EnterTown;

    @FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
    WebElement btn_SofiaTown;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input")
    WebElement txt_address;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr/td[2]/span/span")
    WebElement deliveryPrice;



    private final WebDriver driver;

    public Shipping_Lilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterPhone(String phoneNumber) {
        txt_telephone.sendKeys(phoneNumber);
    }

    public void enterTown(String town) throws InterruptedException {
        btn_radioDeliveryAddress.click();
        btn_TownDropDown.click();
        txt_EnterTown.sendKeys(town);
        Thread.sleep(1000);
        btn_SofiaTown.click();
    }

    public void enterAddress(String address) {
        txt_address.sendKeys(address);
    }


    public void getDeliveryPrice() {
        System.out.println(deliveryPrice.getAttribute("data-bind=\"text: getFormattedPrice(method.price_excl_tax)\""));
    }
}
