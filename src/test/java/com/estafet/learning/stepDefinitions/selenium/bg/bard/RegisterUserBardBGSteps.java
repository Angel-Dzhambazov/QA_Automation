package com.estafet.learning.stepDefinitions.selenium.bg.bard;

import com.estafet.learning.pages.bg.bard.HomePageBard;
import com.estafet.learning.pages.bg.bard.RegisterPageBard;
import dataProvider.ConfigFile_BardBG_Reader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterUserBardBGSteps {

    WebDriver driver = null;
    HomePageBard home;
    RegisterPageBard register;

    ConfigFile_BardBG_Reader configFileReader;

    @Given("Browser is open on Bard")
    public void isBrowserOpen() {
        configFileReader = new ConfigFile_BardBG_Reader();

        WebDriverManager.chromedriver().browserVersion(configFileReader.getBrowserVersion()).setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("user is on bard page")
    public void isLoginPage() throws InterruptedException {
        driver.get(configFileReader.getApplicationUrl());
        Thread.sleep(1000);
    }

    @When("I click on registration page")
    public void clickOnRegisterPage() throws InterruptedException {
        home = new HomePageBard(driver);
        home.clickOnRegistration();
    }

    @And("I create a test user")
    public void createUser(DataTable table) {
        register = new RegisterPageBard(driver);
        register.populateTextFields(table);
    }

    @Then("homepage should be shown")
    public void isHomePageVisible() {
    }

    @When("created user logs in")
    public void createdUserLogsIn() {
    }

    @Then("user page is shown")
    public void isUserPageShown() {
    }
}
