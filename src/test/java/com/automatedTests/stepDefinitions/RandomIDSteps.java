package com.automatedTests.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.automatedTests.stepDefinitions.utils.Helper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RandomIDSteps {

    private static int randomID = -999;
    private static int randomNumber = -999;

    @When("I pick a random {string}")
    public void pickRandomCustomer(String tableName) {
        randomID = Helper.getRandomUniqueIDFromTable(tableName);
    }

    @Then("I can count all his {string}")
    public void getCountOfOrders(String tableName) {
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        switch (tableName) {
            case "orders":
                rs = Helper.selectFromTable("orders", "customer_number", String.valueOf(randomID));
                break;
            case "":
                break;
            default:
                System.out.println("ERROR: Switch case could not find entry, there is some error!");
        }
        sb.append("Our random customer has ID: ").append(randomID).append(System.lineSeparator());
        sb.append("This customer has a total orders of ").append(Helper.getTotalEntriesInResultSet(rs));
        System.out.println(sb.toString());
    }

    @And("I can print all his orders")
    public void printAllOrdersOfCustomer() {
        ResultSet rs = Helper.selectFromTable("orders", "customer_number", String.valueOf(randomID));
        try {
            Helper.printResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @When("I pick a random number between {int} and {int}")
    public void generateRandomNumber(int min, int max) {
        randomNumber = (int) ((Math.random() * (max)) + min + 0);
    }

    @Then("Then I select this random {string}.")
    public void getRandomEntry(String tableName) {
        ResultSet rs = null;
            switch (tableName) {
                case "products":
                    rs = Helper.selectFromTable(tableName, "product_code", String.valueOf(randomNumber));
                    break;
                case "customers":
                    rs = Helper.selectFromTable(tableName, "customer_number", String.valueOf(randomNumber));
                    break;
                default:
                    System.out.println("ERROR could not select any case in this switch case!");
                    break;
            }
        try {
            Helper.printResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
