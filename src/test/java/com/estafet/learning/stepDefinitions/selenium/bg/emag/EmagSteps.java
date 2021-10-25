package com.estafet.learning.stepDefinitions.selenium.bg.emag;

import com.estafet.learning.pages.bg.emag.HomePageEmag;
import com.estafet.learning.pages.bg.emag.LoginPageEmag;
import com.estafet.learning.pages.bg.emag.TyresPageEmag;
import dataProvider.ConfigFileBardBGReader;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class EmagSteps {

    private static WebDriver driver = null;
    private static WebDriverWait waitDriver = null;

    ConfigFileReader configFileReader;

    HomePageEmag homePageEmag;
    LoginPageEmag loginPageEmag;
    TyresPageEmag tyresPageEmag;

    @Given("{string} Browser is open on Emag")
    public void isBrowserOpen(String hostType) {
        configFileReader = new ConfigFileReader();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        if ("Local".equals(hostType)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if ("Docker".equals(hostType)) {
            try {
                URL dockerURL = new URL("http://localhost:4444/wd/hub");
                options.addArguments("PlatformName", "Linux");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                driver = new RemoteWebDriver(dockerURL, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if ("Remote".equals(hostType)) {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        waitDriver = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configFileReader.getEmagUrl());
        homePageEmag = new HomePageEmag(driver);
    }

    @When("user searches for a {string} in search filed")
    public void searchForItem(String item) {

        homePageEmag.homePageLogo.click();
        homePageEmag.search.sendKeys(item);
        homePageEmag.search.sendKeys(Keys.ENTER);
    }

    @And("user logs in")
    public void login() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePageEmag.myAccount.click();
        loginPageEmag = new LoginPageEmag(driver);
        loginPageEmag.login(configFileReader);

    }

    @And("user navigates to tyre directory")
    public void navigateToTyres() {
        homePageEmag.navigateToTyresDepartment();

    }

    @Then("adds random product in favourites")
    public void addItemToFavourites() {
        tyresPageEmag = new TyresPageEmag(driver);

        tyresPageEmag.addRandomTyreToFavourites();
    }

    @And("checkouts all {string} tyres")
    public void checkoutsAllTyres(String item) {
    }
}
