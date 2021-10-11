package com.estafet.learning.stepDefinitions.selenium.bg.bard;

import com.estafet.learning.pages.bg.bard.HomePageBard;
import com.estafet.learning.pages.bg.bard.RegisterPageBard;
import dataProvider.ConfigFileBardBGReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RegisterUserBardBGSteps {

    WebDriver driver = null;
    HomePageBard home;
    RegisterPageBard register;

    ConfigFileBardBGReader configFileReader;

    @Given("{string} Browser is open on Bard")
    public void isBrowserOpen(String hostType) {
        configFileReader = new ConfigFileBardBGReader();

        if("Local".equals(hostType)){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        } else if ("Docker".equals(hostType)) {
            try {
                URL dockerURL = new URL("http://localhost:4444/wd/hub");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("PlatformName", "Linux");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--start-maximized");
                options.addArguments("--headless");
                driver = new RemoteWebDriver(dockerURL, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @And("user is on bard page")
    public void isLoginPage() throws InterruptedException {
        driver.get(configFileReader.getBardApplicationUrl());
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
