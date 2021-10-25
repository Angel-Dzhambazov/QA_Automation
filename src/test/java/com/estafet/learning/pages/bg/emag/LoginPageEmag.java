package com.estafet.learning.pages.bg.emag;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageEmag {

    public final WebDriver driver;

    public LoginPageEmag(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "user_login_email")
    public WebElement enterEmail;

    @FindBy(id = "user_login_continue")
    public WebElement loginButton;

    @FindBy(id = "user_login_password")
    public WebElement enterPassword;

    @FindBy(id = "user_login_continue")
    public WebElement passwordContinue;

    public void login(ConfigFileReader configFileReader) {

        enterEmail.sendKeys(configFileReader.getEmagUsername());
        loginButton.click();

        enterPassword.sendKeys(configFileReader.getPassword());
        passwordContinue.click();
    }
}
