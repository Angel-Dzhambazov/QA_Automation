package com.estafet.learning.pages.bg.abv;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPageABV {

    private static final String GDPR_FRAME = "abv-GDPR-frame";
    private static final String GDPR_ACCEPT_FRAME = "gdpr-consent-notice";

    @FindBy(xpath = "/html/body/app-root/app-theme/div/div/app-notice/app-theme/div/div/app-home/div/div[2]/app-footer/div/div[2]/app-action-buttons/div/button[2]/span[1]/div")
    WebElement btnАcceptCookies;


    public CookiesPageABV(WebDriver webDriver) {
        webDriver.switchTo().frame(GDPR_FRAME);
        webDriver.switchTo().frame(GDPR_ACCEPT_FRAME);
        PageFactory.initElements(webDriver, this);
    }

    public void acceptCookies() {
        btnАcceptCookies.click();
    }
}
