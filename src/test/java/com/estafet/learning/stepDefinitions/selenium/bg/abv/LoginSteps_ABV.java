package com.estafet.learning.stepDefinitions.selenium.bg.abv;

import com.estafet.learning.pages.bg.abv.CookiesPage_ABV;
import com.estafet.learning.pages.bg.abv.HomePage_ABV;
import com.estafet.learning.pages.bg.abv.LoginPage_ABV;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps_ABV {
    WebDriver driver = null;
    LoginPage_ABV login;
    HomePage_ABV home;
    CookiesPage_ABV cookies;

    @Given("Browser is open")
    public void isBrowserOpen() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void isLoginPage() throws InterruptedException {
        driver.get("https://www.abv.bg/");
        Thread.sleep(1000);
    }

    @And("user accepts cookies")
    public void acceptCookies(){
        login = new LoginPage_ABV(driver);
        cookies = new CookiesPage_ABV(driver);
        cookies.acceptCookies();
    }


    @When("^user enters (.*) and (.*)$")
    public void enterCredentials(String username, String password) throws InterruptedException {
        Thread.sleep(1000 / 2);
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("user clicks on login")
    public void clickLogin() {
        login.clickOnLogin();
    }


    @Then("user is navigated to the home page")
    public void navigateToHomePage() throws InterruptedException {
        home = new HomePage_ABV(driver);
        home.logout();
        driver.close();
        driver.quit();
    }


}
