package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    private By signInBtn = By.id("SubmitLogin");
    private By pageHeading = By.cssSelector("h1[class='page-heading']"); // From my account page

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String enterUserCredentials(String userName, String password){
        driver.findElement(emailLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signInBtn).click();
        return driver.findElement(pageHeading).getText();
    }
}
