package com.estafet.learning.pages.bg.lillyDrogerie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Lilly {
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement btn_login;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/nav/div[2]/ul/li[1]/a")
    WebElement btn_discounts;
    /*

    @FindBy(partialLinkText = "Вход")
    WebElement btn_login;

     */

    public HomePage_Lilly(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogin() {
        btn_login.click();
    }

    public void clickOnDiscounts() {
        btn_discounts.click();
    }
}
