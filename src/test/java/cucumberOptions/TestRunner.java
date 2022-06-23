package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber-reports/cucumber.json"},
        tags = "@Cart"
        )
public class TestRunner extends AbstractTestNGCucumberTests {

}
