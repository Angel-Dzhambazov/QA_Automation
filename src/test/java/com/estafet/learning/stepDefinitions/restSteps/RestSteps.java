package com.estafet.learning.stepDefinitions.restSteps;

import com.estafet.learning.api.rest.config.RestManager;
import com.estafet.learning.api.rest.pojos.EmployeePojo;
import com.estafet.learning.api.rest.restBaseMethods.BaseEmployees;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class RestSteps {
    RestManager manager = new RestManager();
    Response response;

    List<String> allEmployees;

    @Given("the user gets all employees")
    public void getAllEmployees() {
        response = manager.getBaseEmployees().getAllEmployees();
    }


    @Given("the user creates a new record in database")
    public void postNewEmployee() {
        response = manager.getBaseEmployees().createNewEmployee(new EmployeePojo());
    }

    @Given("the user gets random employee data")
    public void getEmployeeInformation() {
        manager.getBaseEmployees().getEmployeeInformation();
    }

    @Then("verify status of get request is {int}")
    public void verifyStatusOfGetRequestIs(int expectedCode) {
        Assert.assertEquals("Status code is not as expected", expectedCode, response.getStatusCode());
    }
}