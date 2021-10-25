package com.estafet.learning.pages.bg.emag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageEmag {
    public final WebDriver driver;

    Actions actions;

    public HomePageEmag(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    @FindBy(id = "searchboxTrigger")
    public WebElement search;


    @FindBy(xpath = "//*[@id=\"my_account\"]/span")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[1]/a/img")
    public WebElement homePageLogo;

    @FindBy(xpath = "//*[@id=\"auxiliary\"]/div/div/ul[2]/li[1]/a")
    public WebElement dailyOffers;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div[1]/ul/li[13]/a/span")
    public WebElement automobileDepartment;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/div[12]/div[2]/ul/li[1]/a[1]")
    public WebElement tyresDepartment;

    public void navigateToTyresDepartment() {
        actions.moveToElement(automobileDepartment).perform();
        actions.moveToElement(tyresDepartment).perform();
        actions.click().perform();
    }


}
