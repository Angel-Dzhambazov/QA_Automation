package com.estafet.learning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class Main {

    @FindBy(how = How.CLASS_NAME, using = "classname")
    private static List<WebElement> singlecriterion;

    @FindBy(className = "classname")
    private static List<WebElement> sameAsTop;

    @FindBy(how = How.ID, using = "elementid")
    private static WebElement element;

    @FindBys({
            @FindBy(how = How.NAME, using = "username"),
            @FindBy(how = How.NAME, using = "password")
    })
    private static List<WebElement> bothcriteria;

    @FindAll({
            @FindBy(how = How.NAME, using = "username"),
            @FindBy(how = How.NAME, using = "password")
    })
    private static List<WebElement> eithercriterion;

    public static void main(String[] args) {
        System.out.println("Using @FindBy, we found " + singlecriterion.size() + " element(s)");
        System.out.println("Using @FindBys, we found " + bothcriteria.size() + " element(s)");
        System.out.println("Using @FindAll, we found " + eithercriterion.size() + " element(s)");
    }
}
