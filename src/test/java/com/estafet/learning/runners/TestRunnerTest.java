package com.estafet.learning.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features/selenium/bg.bard",
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json"},
        tags = "@bardbg",
        glue = {"com.estafet.learning.stepDefinitions"})
public class TestRunnerTest {
}