package com.estafet.learning.pages.bg.lillyDrogerie;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingLilly {

    @FindBy(name = "telephone")
    WebElement txtTelephone;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/div/label[2]")
    WebElement btnRadioDeliveryAddress;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[6]/div/span/span[1]/span")
    WebElement btnTownDropDown;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement txtEnterTown;

    @FindBy(xpath = "/html/body/span/span/span[2]/ul/li")
    WebElement btnSofiaTown;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input")
    WebElement txtAddress;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr/td[2]/span/span")
    WebElement deliveryPrice;

    @FindBy(className = "logo")
    WebElement btnNavigateToHomePage;


    private final WebDriver driver;

    public ShippingLilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterPhone(String phoneNumber) {
        txtTelephone.sendKeys(phoneNumber);
    }

    public void enterTown(String town) throws InterruptedException {
        btnRadioDeliveryAddress.click();
        btnTownDropDown.click();
        txtEnterTown.sendKeys(town);
        Thread.sleep(1000);
        btnSofiaTown.click();
    }

    public void enterAddress(String address) {
        txtAddress.sendKeys(address);
    }


    public void getDeliveryPrice(String expectedPrice) {
        String actualPrice = driver.findElement(By.xpath("//span[@class=\"price\"]/span[@class=\"price\"]")).getText();
        actualPrice = actualPrice.replaceAll(",", ".");
        double priceForDelivery = Double.parseDouble(actualPrice.substring(0, actualPrice.length() - 4));

        double expectedPriceD = Double.parseDouble(expectedPrice);

        Assert.assertEquals("Delivery price is not as expected!", priceForDelivery, expectedPriceD, 0.0);
    }

    public void navigateToHomePage() {
        btnNavigateToHomePage.click();
    }
}
