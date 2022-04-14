package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import reportConfig.Log;
import utils.TestBase;

import java.net.MalformedURLException;

public class LoginStepDefinitions extends TestBase {
    boolean result;
    @Given("User is Navigated to Login Page")
    public void user_is_navigated_to_login_page() throws MalformedURLException {
        setUp();
        Log.info("Landing on home page");
        homePage.clickLogin();
    }
    @When("User login with username {string} and password {string}")
    public void user_login_with_username_and_password(String userName, String password) {
        Log.info("Trying login in account");
        result = homePage.enterCustomerCredentials(userName,password);
    }
    @Then("User login will be {string}")
    public void user_login_will_be(String expectedResult) {
        Log.info("Assertion test results");

        if (!result){
            Assert.assertEquals(expectedResult,"pass");
        }
        else{
            Assert.assertEquals(expectedResult,"fail");
        }

        tearDown();
    }
}
