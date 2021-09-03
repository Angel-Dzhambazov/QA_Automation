package com.estafet.learning.pages.bg.bard;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPageBard {
    @FindBy(name = "data[email]")
    WebElement txt_email;

    @FindBy(name = "data[password1]")
    WebElement txt_password;

    @FindBy(name = "data[password2]")
    WebElement txtRepeatPassword;

    @FindBy(name = "data[phone]")
    WebElement txtPhone;

    @FindBy(name = "data[firstname]")
    WebElement txtName;

    @FindBy(name = "data[surname]")
    WebElement txtSurname;

    @FindBy(name = "data[family]")
    WebElement txtFamilyName;

    @FindBy(name = "data[postcode]")
    WebElement txtPostCode;

    @FindBy(name = "data[city]")
    WebElement txtTown;

    @FindBy(name = "data[address]")
    WebElement txtAddress;

    @FindBy(name = "data[agree_gdpr]")
    WebElement checkBoxAgreeGDPR;

    @FindBy(name = "data[confirm_age]")
    WebElement checkBoxConfirmAge;

    @FindBy(name = "data[agree_bulletin]")
    WebElement checkBoxAgreeADS;


    private final WebDriver driver;

    public RegisterPageBard(WebDriver webDriver) {
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
            txtRepeatPassword.sendKeys(pass2);
            txtPhone.sendKeys(phone);

            txtName.sendKeys(name);
            txtSurname.sendKeys(surname);
            txtFamilyName.sendKeys(family);
            txtPostCode.sendKeys(postCode);
            txtTown.sendKeys(town);
            txtAddress.sendKeys(address);
        }

        checkBoxAgreeGDPR.click();
        checkBoxConfirmAge.click();
        checkBoxAgreeADS.click();

//        btn_register.click();
    }
}
