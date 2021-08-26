package com.estafet.learning.pages.bg.abv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_ABV {
    @FindBy(id = "username")
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "loginBut")
    WebElement btn_login;

    WebDriver webDriver;

    public LoginPage_ABV(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickOnLogin() {
        btn_login.click();
    }
}
