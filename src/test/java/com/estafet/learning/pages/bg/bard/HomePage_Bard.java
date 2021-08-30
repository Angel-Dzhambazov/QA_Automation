package com.estafet.learning.pages.bg.bard;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Bard {

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div")
    WebElement myProfile;

    @FindBy(linkText = "Регистрация")
    WebElement registration;


    private static WebDriver driver;

    public HomePage_Bard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnRegistration() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(myProfile).build().perform();
        WebElement we = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div"));
        action.moveToElement(we).build().perform();

        Thread.sleep(1000 * 3);

        registration.click();
    }
}
