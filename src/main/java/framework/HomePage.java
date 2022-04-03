package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By login = By.cssSelector("a[class='login']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage loginPage(){
        driver.findElement(login).click();
        return new LoginPage(driver);
    }

}
