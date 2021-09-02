package com.estafet.learning.stepDefinitions.selenium.bg.lillyDrogerie;

import com.estafet.learning.pages.bg.lillyDrogerie.HomePage_Lilly;
import com.estafet.learning.pages.bg.lillyDrogerie.LoginPage_Lilly;
import dataProvider.ConfigFile_Lilly_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuyProducts_Lilly_Steps {

    WebDriver driver;
    ConfigFile_Lilly_Reader lillyReader;
    HomePage_Lilly home;
    LoginPage_Lilly login;

    @Given("Browser is open on Lilly")
    public void isBrowserOpen() {
        lillyReader = new ConfigFile_Lilly_Reader();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion(lillyReader.getBrowserVersion()).setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(lillyReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(lillyReader.getImplicitlyWait(), TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("user successfully logs in")
    public void loginLilly() throws InterruptedException {
        driver.get(lillyReader.getApplicationUrl());

        Thread.sleep(1000);

        /*

        home = new HomePage_Lilly(driver);
        Thread.sleep(1000);
        home.clickOnDiscounts();

        home.clickOnLogin();


         */

    }
}
