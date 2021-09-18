package com.estafet.learning.stepDefinitions.oracleVsMySqlSteps;

import com.estafet.learning.stepDefinitions.utils.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CompareDatabasesSteps {

    int randomID = -999;

    @When("I pick a random {string}")
    public void pickRandomCustomer(String tableName) {
        randomID = Helper.getRandomUniqueIDFromTable(tableName);
    }

    @Given("^successful connection to MySQL database (.*)$")
    public void successfulConnectionToMySQLDatabaseTable(String tableName) {

    }
}
