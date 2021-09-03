package com.estafet.learning.pages.bg.abv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageABV {
    @FindBy(id = "username")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "loginBut")
    WebElement btnLogin;
    
    public LoginPageABV(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickOnLogin() {
        btnLogin.click();
    }
}
