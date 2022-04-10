package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WindowControl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    By cartLink = By.xpath("//a[text()='Cart']");
    By loginLink = By.id("login2");
    By userNameLocator = By.id("loginusername");
    By passwordLocator = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");
    By itemLink = By.cssSelector("div[class*='col-md-6'] a[class='hrefch']");
    By itemPrice = By.xpath("//div[contains(@class,'col-md-6')]/div/div/h5");

    private WebDriver driver;



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public Boolean enterCustomerCredentials(String userName, String password)  {
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginBtn).click();
        return WindowControl.isAlertPresent(driver);
    }

    public Product clickFirstItem(){
        List<WebElement> elements;
        elements = driver.findElements(itemLink);
        elements.get(0).click();
        return new Product(driver);
    }

    public String getFirstItemPrice(){
        List<WebElement> elements = driver.findElements(itemPrice);
        return elements.get(0).getText();
    }

    public Cart addMultipleItems() {
        Product product = new Product(driver);
        List<WebElement> elements;
        for (int i=0; i<=2; i++) {
            elements = driver.findElements(itemLink);
            elements.get(i*2).click();
            product.clickAddForMultiple();
        }
        driver.findElement(cartLink).click();
        return new Cart(driver);
    }

}
