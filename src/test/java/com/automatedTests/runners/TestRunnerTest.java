package com.automatedTests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.automatedTests.jUnitTests.OrderTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty"}, tags = "@students",
        glue = {"src/test/java/com/automatedTests/stepDefinitions"})
public class TestRunnerTest {
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(OrderTest.class);
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println("Result==" + result.wasSuccessful());
//    }
}
