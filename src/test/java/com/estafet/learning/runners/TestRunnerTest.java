package com.estafet.learning.runners;

import com.estafet.learning.jUnitTests.OrderTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty"}, tags = "@sprint3",
        glue = {"com.estafet.learning.stepDefinitions"})
public class TestRunnerTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(OrderTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Result==" + result.wasSuccessful());
    }
}
