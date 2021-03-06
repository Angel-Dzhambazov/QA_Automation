package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedItemsListLilly {

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[1]/div/div[4]/select")
    WebElement btnSortBy;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[1]/div/div[4]/select/option[5]")
    WebElement btnPriceA;

    @FindBy(xpath = "//*[@id=\"sorter\"]/option[6]")
    WebElement btnPriceD;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[1]")
    WebElement btnShoppingCart;

    private final WebDriver driver;

    public SelectedItemsListLilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void sortByPriceA() {
        btnSortBy.click();
        btnPriceA.click();
    }

    public void sortByPriceD() {
        btnSortBy.click();
        btnPriceD.click();
    }

    public void buyFirstShower(int numberOfShower) throws InterruptedException {
        String hoverXPathOfElement =
                "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[2]/ol/li[" + numberOfShower + "]/div";
        String btn_buyXPath = "/html/body/div[2]/main/div[2]/div[1]/div[5]/div[2]/ol/li[" + numberOfShower +
                "]/div/div/div[2]/div/div[1]/form/button";

        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath(hoverXPathOfElement))).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btn_buyXPath)).click();
    }

    public void clickOnShoppingCart() {
        btnShoppingCart.click();
    }
}
