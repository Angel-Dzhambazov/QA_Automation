import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty"}, tags = "@selenium",
        glue = {"stepDefinitions"})

public class CucumberRunner {
}
