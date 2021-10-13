package com.estafet.learning.pages.bg.bard;

import com.estafet.learning.pages.bg.lillyDrogerie.HomePageLilly;
import org.openqa.selenium.WebDriver;

public class BardPageManager {
    private WebDriver driver;

    HomePageBard homePage;
    LoginPageBard loginPage;
    RegisterPageBard registerPage;

    public BardPageManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePageBard getHomePage() {
        return (homePage == null) ? homePage = new HomePageBard(driver) : homePage;
    }

    public LoginPageBard getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPageBard(driver) : loginPage;
    }

    public RegisterPageBard getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPageBard(driver) : registerPage;
    }
}
