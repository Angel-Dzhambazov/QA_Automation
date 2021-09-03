package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLilly {
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement btnLogin;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/a[1]")
    WebElement btnAcceptCookies;

    @FindBy(id = "ui-id-8")
    WebElement btnManCare;

    @FindBy(id = "ui-id-9")
    WebElement btnPerfumes;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElement btnNavigateToCart;


    public final WebDriver driver;

    public HomePageLilly(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void accepctCookies() {
        btnAcceptCookies.click();
    }

    public void clickOnLogin() {
        btnLogin.click();
    }

    public void clickOnShowerGels() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(btnManCare).build().perform();
        Thread.sleep(500);
        WebElement we = driver.findElement(By.id("ui-id-187"));
        action.moveToElement(we).build().perform();
        Thread.sleep(500);
        driver.findElement(By.id("ui-id-198")).click();
    }

    public void navigateToCart() {
        btnNavigateToCart.click();
    }

    public void clickOnPerfumes() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(btnPerfumes).build().perform();
        Thread.sleep(500);
        WebElement we = driver.findElement(By.id("ui-id-203"));
        action.moveToElement(we).build().perform();
        Thread.sleep(500);
        driver.findElement(By.id("ui-id-205")).click();
    }
}
