package com.automatedTests.stepDefinitions.selenium;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class InitialSteps {


    @Given("^I Have installed webDriver and I can open a browser$")
    public void openBrowser() {

        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("enable-automation");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-gpu");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
