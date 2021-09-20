package com.estafet.learning.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty"}, tags = "@SQLvsORACLE",
        glue = {"com.estafet.learning.stepDefinitions"})
public class TestRunnerTest {

}
