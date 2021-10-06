package com.estafet.learning.stepDefinitions.selenium.bg.lillyDrogerie;


import com.estafet.learning.pages.TakeScreenShot;
import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BuyProductsLillySteps {

    ConfigFileReader configFileReader;
    PageObjectManager pageObjectManager;

    @Before("@Smoke,@Regression")
    public void beforeScenario(){
        System.out.println("New scenario begins");
    }

    @After("@Smoke,@Regression")
    public void afterScenario(){
        System.out.println("Scenario ends");


    }

    @Given("Browser is open on Lilly")
    public void isBrowserOpen() {
        System.out.println("opening browser on lilly!");
        configFileReader = new ConfigFileReader();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        TakeScreenShot.takeSnapShot(driver);
        driver.get(configFileReader.getLillyApplicationUrl());
        TakeScreenShot.takeSnapShot(driver);
        pageObjectManager = new PageObjectManager(driver);
    }

    @And("user successfully logs in")
    public void loginLilly() throws InterruptedException {
        System.out.println("Logging in on lilly!");
        pageObjectManager.getHomePage().accepctCookies();
        Thread.sleep(500);
        pageObjectManager.getHomePage().clickOnLogin();

        pageObjectManager.getLoginPage().enterCredentials();
        pageObjectManager.getLoginPage().clickLogin();
    }

    @When("^user clicks on category (.*)$")
    public void chooseCategory(String category) throws InterruptedException {
        System.out.println("Choosing category in on lilly!");
        switch (category) {
            case "man care":
                pageObjectManager.getHomePage().clickOnShowerGels();
                break;
            case "perfume":
                pageObjectManager.getHomePage().clickOnPerfumes();
                break;
            default:
                Assert.fail("Could not find category!");
                break;
        }
    }

    @And("^user arranges the items by price (.*)$")
    public void arrangeItems(String ascendType) {
        switch (ascendType) {
            case "ascending":
                pageObjectManager.getSelectedItemsPage().sortByPriceA();
                break;
            case "descending":
                pageObjectManager.getSelectedItemsPage().sortByPriceD();
                break;
            default:
                Assert.fail("could not select proper ascend way");
        }
    }

    @And("user buys the first {int} items")
    public void buyItems(int numberOfShowerGels) throws InterruptedException {
        for (int i = 1; i <= numberOfShowerGels; i++) {
            pageObjectManager.getSelectedItemsPage().buyFirstShower(i);
        }
    }

    @Then("^total price of the order should be (.*) than (.*)$")
    public void checkTotalPrice(String moreOrLess, String priceLimit) throws InterruptedException {
        pageObjectManager.getSelectedItemsPage().clickOnShoppingCart();

        String currentPrice = pageObjectManager.getShoppingCartPage().getTotalPrice();
        currentPrice = currentPrice.replaceAll(",", ".");
        double currentPriceD = Double.parseDouble(currentPrice.substring(0, currentPrice.length() - 4));
        double priceToCompareWith = Double.parseDouble(priceLimit);

        switch (moreOrLess) {
            case "less":
                Assert.assertTrue("Current price is not as expected", currentPriceD < priceToCompareWith);
                break;
            case "more":
                Assert.assertTrue("Current price is not as expected", currentPriceD >= priceToCompareWith);
                break;
            default:
                Assert.fail("Could not find method to compare with!");
                break;
        }
        pageObjectManager.getShoppingCartPage().finishOrder();
        pageObjectManager.getShippingPage().enterPhone(configFileReader.getPhoneNumber());
        pageObjectManager.getShippingPage().enterTown(configFileReader.getTown());
        pageObjectManager.getShippingPage().enterAddress(configFileReader.getAddress());
    }

    @And("^delivery cost should be (.*)$")
    public void checkDeliveryPrice(String deliveryPrice) throws InterruptedException {
        Thread.sleep(1000);
        pageObjectManager.getShippingPage().getDeliveryPrice(deliveryPrice);
    }

    @And("delete all items from shopping cart")
    public void deleteAllItems() {
        pageObjectManager.getShippingPage().navigateToHomePage();
        pageObjectManager.getHomePage().navigateToCart();
        pageObjectManager.getShoppingCartPage().deleteAllitems();
    }
}