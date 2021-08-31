package com.estafet.learning.pages.bg.abv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_ABV {
    @FindBy(id = "gwt-uid-386")
    WebElement accountOptions;

    @FindBy(id = "gwt-uid-389")
    WebElement logout;


    public HomePage_ABV(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void logout() throws InterruptedException {
        accountOptions.click();
        Thread.sleep(1000 * 2);
        logout.click();
        Thread.sleep(1000 * 2);
    }
}
