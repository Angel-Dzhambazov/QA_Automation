package com.estafet.learning.stepDefinitions.selenium.bg.bard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterUserSteps {

    WebDriver driver = null;

    @Given("Browser is open")
    public void isBrowserOpen() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("user is on bard page")
    public void isLoginPage() throws InterruptedException {
        driver.get("https://www.bard.bg/");
        Thread.sleep(1000);
    }
}
