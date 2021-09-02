package com.estafet.learning.stepDefinitions.selenium.bg.lillyDrogerie;

import com.estafet.learning.pages.bg.lillyDrogerie.HomePage_Lilly;
import com.estafet.learning.pages.bg.lillyDrogerie.LoginPage_Lilly;
import com.estafet.learning.pages.bg.lillyDrogerie.ShowerGels_Lilly;
import com.sun.corba.se.spi.ior.IdentifiableFactory;
import dataProvider.ConfigFile_Lilly_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.util.concurrent.TimeUnit;

public class BuyProducts_Lilly_Steps {

    WebDriver driver;
    ConfigFile_Lilly_Reader lillyReader;
    HomePage_Lilly home;
    LoginPage_Lilly login;
    ShowerGels_Lilly showersPage;

    @Given("Browser is open on Lilly")
    public void isBrowserOpen() {
        lillyReader = new ConfigFile_Lilly_Reader();
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(lillyReader.getImplicitlyWait(), TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("user successfully logs in")
    public void loginLilly() throws InterruptedException {
        driver.get(lillyReader.getApplicationUrl());

        Thread.sleep(1000);

        home = new HomePage_Lilly(driver);
        Thread.sleep(500);
        home.accepctCookies();
        Thread.sleep(500);
        home.clickOnLogin();

        login = new LoginPage_Lilly(driver);
        login.enterCredentials();
        login.clickLogin();
    }

    @When("^user clicks on category (.*)$")
    public void chooseCategory(String category) throws InterruptedException {
        System.out.println("==============================================================================");
        System.out.println(category);
        System.out.println("==============================================================================");
        switch (category) {
            case "man care":
                home.clickOnShowerGels();
                break;
            case "":
                break;
            default:
                System.out.println("Could not find category!");
                break;

        }
    }

    @And("^user arranges the items by price (.*)$")
    public void arrangeItems(String ascendType) {
        showersPage = new ShowerGels_Lilly(driver);
        showersPage.sortByPriceA();
    }

    @And("user buys the first {int} items")
    public void buyItems(int arg0) {
        showersPage.printAllElements();
    }
}
