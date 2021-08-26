package com.estafet.learning.stepDefinitions.selenium;

import com.estafet.learning.pages.ExcitePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InitialSteps {

    WebDriver driver = null;

    @Given("^I Have installed webDriver and I can open a browser$")
    public void openBrowser() {


        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();

        driver = new ChromeDriver();
        driver.get("https://www.excite.com/");
        driver.manage().window().maximize();
    }

    @When("I click on accept cookies")
    public void acceptCookies() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExcitePage.acceptCookies(driver).click();
    }
}
