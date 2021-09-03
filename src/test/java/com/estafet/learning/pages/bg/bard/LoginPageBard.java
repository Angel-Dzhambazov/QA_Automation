package com.estafet.learning.pages.bg.bard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageBard {

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div")
    WebElement myProfile;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/div/div/ul/li[3]/a")
    WebElement btn_register;

    WebDriver webDriver;


    public LoginPageBard(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void hoverOverMyProfile(String password) {
        Actions action = new Actions(webDriver);
        action.moveToElement(myProfile).build().perform();
    }

    public void clickOnLogin() {
        btn_register.click();
    }
}


