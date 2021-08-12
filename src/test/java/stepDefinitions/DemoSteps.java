package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoSteps {
    @Given("I have set up {string}")
    public void iHaveSetUp(String arg0) {
    }

    @When("I {string} test")
    public void iTest(String arg0) {
    }

    @Then("Test is {string}")
    public void testIs(String arg0) {
    }
}
