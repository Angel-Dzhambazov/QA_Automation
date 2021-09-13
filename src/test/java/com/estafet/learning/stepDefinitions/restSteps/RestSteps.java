package com.estafet.learning.stepDefinitions.restSteps;

import com.estafet.learning.api.rest.config.RestManager;
import com.estafet.learning.api.rest.pojos.EmployeePojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RestSteps {
    private static final Logger LOGGER = LogManager.getLogger(RestSteps.class);
    RestManager manager = new RestManager();
    Response response;

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
        response = manager.getBaseEmployees().getRandomEmployeeInformation();
    }

    @Then("verify status of get request is {int}")
    public void verifyStatusOfGetRequestIs(int expectedCode) {
        Assert.assertEquals("Status code is not as expected", expectedCode, response.getStatusCode());
    }

    @Then("confirm employee has name and surname")
    public void getEmployeeNames() {
        String initialSubtractStringIndexStart = "employee_name"; //start of names
        String initialSubtractStringIndexEnd = "employee_salary"; //end of names

        String responseString = response.body().asString();
        String employeeNames = responseString.substring(responseString.indexOf(initialSubtractStringIndexStart),
                responseString.indexOf(initialSubtractStringIndexEnd));

        String secondSubstringStart = "\":\"";
        String secondSubstringEnd = "\",\"";
        employeeNames = employeeNames
                .substring(employeeNames.indexOf(secondSubstringStart) + 3, employeeNames.indexOf(secondSubstringEnd));

        boolean result = manager.getBaseEmployees().areTheseTwoNames(employeeNames);
        Assert.assertTrue("Generated names were not in pattern!", result);
    }

    @Given("user deletes random employee")
    public void deleteRandomEmployee() {
        response = manager.getBaseEmployees().deleteRandomEmployeeInformation();
    }

    @Then("verify return message is {string}")
    public void verifyReturnMessage(String expectedMessage) {
        Assert.assertTrue("Message is not as expected!", response.body().asString().contains(expectedMessage));
    }

    @Then("user updates employee's salary")
    public void updateSalary() {
        String id = getEmployeeID();
        String employeeBody = getEmployeeBody();
        manager.getBaseEmployees().updateSalary(id, employeeBody);
    }

    private String getEmployeeBody() {
        String bodyAsString = response.body().asString();
        String employeeBody = bodyAsString
                .substring(bodyAsString.indexOf("\"employee_name\":"), bodyAsString.indexOf(",\"profile_image\""));
        return employeeBody;
    }

    private String getEmployeeID() {
        String responseString = response.body().asString();
        return responseString.substring(responseString.indexOf("\"id\":") + 5, responseString
                .indexOf(",\"employee_name\""));
    }
}