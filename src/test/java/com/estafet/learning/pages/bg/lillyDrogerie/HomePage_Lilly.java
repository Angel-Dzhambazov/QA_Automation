package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Lilly {
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement btn_login;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/nav/div[2]/ul/li[1]/a")
    WebElement btn_discounts;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/a[1]")
    WebElement btn_accpectCookies;


    @FindBy(id = "ui-id-8")
    WebElement btn_manCare;


    @FindBy(className = "action showcart")
    WebElement btn_navigateToCart;

//    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/nav/div[1]/ul/li[7]/a")
//    WebElement btn_manCare;

    public final WebDriver driver;

    public HomePage_Lilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void accepctCookies() {
        btn_accpectCookies.click();
    }

    public void clickOnLogin() {
        btn_login.click();
    }

    public void clickOnDiscounts() {
        btn_discounts.click();
    }

    public void clickOnShowerGels() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(btn_manCare).build().perform();
        Thread.sleep(500);
        WebElement we = driver.findElement(By.id("ui-id-187"));
        action.moveToElement(we).build().perform();
        Thread.sleep(500);
        driver.findElement(By.id("ui-id-198")).click();
    }

    public void navigateToCart() {
        btn_navigateToCart.click();
    }
}
