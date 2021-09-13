package com.estafet.learning.stepDefinitions.soapSteps;

import com.estafet.learning.api.soap.config.SoapManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalculatorSteps {
    int result;

    SoapManager manager = new SoapManager();

    @Given("^user is testing (.*) of calculator with (.*) and (.*)$")
    public void testCalculator(String function, int intA, int intB) {
        result = manager.getBaseCalculator().calculate(function, intA, intB);
    }

    @Then("^result should be as (.*)$")
    public void checkResult(int expectedResult) {
        Assert.assertEquals("Result is not as expected!", expectedResult, result);
    }


}
