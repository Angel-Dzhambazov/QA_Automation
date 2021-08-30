package com.estafet.learning.pages.bg.bard;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage_Bard {
    @FindBy(name = "data[email]")
    WebElement txt_email;

    @FindBy(name = "data[password1]")
    WebElement txt_password;

    @FindBy(name = "data[password2]")
    WebElement txt_repeatPassword;

    @FindBy(name = "data[phone]")
    WebElement txt_phone;

    @FindBy(name = "data[firstname]")
    WebElement txt_name;

    @FindBy(name = "data[surname]")
    WebElement txt_surname;

    @FindBy(name = "data[family]")
    WebElement txt_familyName;

    @FindBy(name = "data[postcode]")
    WebElement txt_postCode;

    @FindBy(name = "data[city]")
    WebElement txt_town;

    @FindBy(name = "data[address]")
    WebElement txt_address;

    @FindBy(name = "data[agree_gdpr]")
    WebElement checkBox_agreeGDPR;

    @FindBy(name = "data[confirm_age]")
    WebElement checkBox_confirmAge;

    @FindBy(name = "data[agree_bulletin]")
    WebElement checkBox_agreeADS;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/form/div[2]/div[6]/a")
    WebElement btn_register;

    private static WebDriver driver;

    public RegisterPage_Bard(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void populateTextFields(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> columns : rows) {
            String mail = columns.get(0);
            String pass = columns.get(1);
            String pass2 = columns.get(1);
            String phone = columns.get(2);
            String name = columns.get(3);
            String surname = columns.get(4);
            String family = columns.get(5);
            String postCode = columns.get(6);
            String town = columns.get(7);
            String address = columns.get(8);

            txt_email.sendKeys(mail);
            txt_password.sendKeys(pass);
            txt_repeatPassword.sendKeys(pass2);
            txt_phone.sendKeys(phone);

            txt_name.sendKeys(name);
            txt_surname.sendKeys(surname);
            txt_familyName.sendKeys(family);
            txt_postCode.sendKeys(postCode);
            txt_town.sendKeys(town);
            txt_address.sendKeys(address);
        }

        checkBox_agreeGDPR.click();
        checkBox_confirmAge.click();
        checkBox_agreeADS.click();

//        btn_register.click();
    }
}
