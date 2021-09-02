package com.estafet.learning.pages.bg.lillyDrogerie;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Lilly {
    @FindBy(name = "login[username]")
    WebElement txt_username;

    @FindBy(name = "login[password]")
    WebElement txt_password;

    @FindBy(id = "send2")
    WebElement btn_login;


    public LoginPage_Lilly(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void enterCredentials() throws InterruptedException {
        txt_username.sendKeys(FileReaderManager.getInstance().CofigFile_Lilly_Reader().getUsername());
        Thread.sleep(1000);
        txt_password.sendKeys(FileReaderManager.getInstance().CofigFile_Lilly_Reader().getPassword());
        Thread.sleep(1000);
    }

    public void clickLogin(){
        btn_login.click();
    }
}
