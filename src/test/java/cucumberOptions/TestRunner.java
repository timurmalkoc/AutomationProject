package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/featureFiles",
        glue = {"stepDefinitions"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {

}
