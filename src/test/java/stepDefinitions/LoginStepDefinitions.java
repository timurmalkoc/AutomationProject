package stepDefinitions;

import framework.HomePage;
import framework.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import reportConfig.Log;
import utils.TestBase;

import java.net.MalformedURLException;

public class LoginStepDefinitions extends TestBase {
    LoginPage loginPage;
    String result;
    @Given("User is Navigated to Login Page")
    public void user_is_navigated_to_login_page() throws MalformedURLException {
        setUp();
        Log.info("Landing on home page");
        loginPage = homePage.loginPage();
    }
    @When("User login with username {string} and password {string}")
    public void user_login_with_username_and_password(String userName, String password) {
        Log.info("Trying login page");
        result = loginPage.enterUserCredentials(userName,password);
    }
    @Then("User login will be {string}")
    public void user_login_will_be(String expectedResult) {
        Log.info("Assertion test results");
        String actual = "MY ACCOUNT";
        if (expectedResult.equals("pass")){
            Assert.assertEquals(actual,result);

        }
        else{
            Assert.assertNotEquals(actual,result);
        }
        tearDown();
    }
}
