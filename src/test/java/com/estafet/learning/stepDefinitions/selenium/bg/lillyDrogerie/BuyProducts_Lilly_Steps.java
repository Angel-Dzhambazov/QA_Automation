package com.estafet.learning.stepDefinitions.selenium.bg.lillyDrogerie;

import com.estafet.learning.pages.bg.lillyDrogerie.*;
import dataProvider.ConfigFile_Lilly_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuyProducts_Lilly_Steps {

    WebDriver driver;
    ConfigFile_Lilly_Reader lillyReader;
    HomePage_Lilly homePage;
    LoginPage_Lilly loginPage;
    ShowerGels_Lilly showersPage;
    ShoppingCart_Lilly shoppingCartPage;
    Shipping_Lilly shippingPage;

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

        homePage = new HomePage_Lilly(driver);
        Thread.sleep(500);
        homePage.accepctCookies();
        Thread.sleep(500);
        homePage.clickOnLogin();

        loginPage = new LoginPage_Lilly(driver);
        loginPage.enterCredentials();
        loginPage.clickLogin();
    }

    @When("^user clicks on category (.*)$")
    public void chooseCategory(String category) throws InterruptedException {
        System.out.println("==============================================================================");
        System.out.println(category);
        System.out.println("==============================================================================");
        switch (category) {
            case "man care":
                homePage.clickOnShowerGels();
                break;
            case "perfume":
                homePage.clickOnPerfumes();
                break;
            default:
                Assert.fail("Could not find category!");
                break;

        }
    }

    @And("^user arranges the items by price (.*)$")
    public void arrangeItems(String ascendType) {
        showersPage = new ShowerGels_Lilly(driver);
        switch (ascendType) {
            case "ascending":
                showersPage.sortByPriceA();
                break;
            case "descending":
                showersPage.sortByPriceD();
                break;
            default:
                Assert.fail("could not select proper ascend way");
        }

    }

    @And("user buys the first {int} items")
    public void buyItems(int numberOfShowerGels) throws InterruptedException {
        for (int i = 1; i <= numberOfShowerGels; i++) {
            showersPage.buyFirstShower(i);
        }

    }

    @Then("^total price of the order should be (.*) than (.*)$")
    public void checkTotalPrice(String moreOrLess, String priceLimit) throws InterruptedException {
        showersPage.clickOnShoppingCart();
        shoppingCartPage = new ShoppingCart_Lilly(driver);

        String currentPrice = shoppingCartPage.getTotalPrice();
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

        shoppingCartPage.finishOrder();

        shippingPage = new Shipping_Lilly(driver);
        shippingPage.enterPhone(lillyReader.getPhoneNumber());

        shippingPage.enterTown(lillyReader.getTown());

        shippingPage.enterAddress(lillyReader.getAddress());


    }

    @And("^delivery cost should be (.*)$")
    public void checkDeliveryPrice(String deliveryPrice) throws InterruptedException {
        Thread.sleep(1000);
        shippingPage.getDeliveryPrice(deliveryPrice);
    }

    @And("delete all items from shopping cart")
    public void deleteAllItems() {
        shippingPage.navigateToHomePage();
        homePage.navigateToCart();
        shoppingCartPage.deleteAllitems();
    }
}
