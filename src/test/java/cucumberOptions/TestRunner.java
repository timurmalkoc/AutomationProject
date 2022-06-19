package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = {"stepDefinitions"},
        tags = ("@UI and @DB")
        )
public class TestRunner extends AbstractTestNGCucumberTests {

}
