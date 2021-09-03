package com.estafet.learning.pages.bg.lillyDrogerie;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLilly {
    @FindBy(name = "login[username]")
    WebElement txtUsername;

    @FindBy(name = "login[password]")
    WebElement txtPassword;

    @FindBy(id = "send2")
    WebElement btnLogin;


    public LoginPageLilly(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void enterCredentials() throws InterruptedException {
        txtUsername.sendKeys(FileReaderManager.getInstance().CofigFile_Lilly_Reader().getUsername());
        Thread.sleep(1000);
        txtPassword.sendKeys(FileReaderManager.getInstance().CofigFile_Lilly_Reader().getPassword());
        Thread.sleep(1000);
    }

    public void clickLogin(){
        btnLogin.click();
    }
}
