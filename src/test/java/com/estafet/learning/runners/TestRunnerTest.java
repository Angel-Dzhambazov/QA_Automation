package com.estafet.learning.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty"}, tags = "@sprint3",
        glue = {"com.estafet.learning.stepDefinitions"})
public class TestRunnerTest {
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(OrderTest.class);
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println("Result==" + result.wasSuccessful());
//    }
}
