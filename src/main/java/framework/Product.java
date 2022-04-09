package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WindowControl;

public class Product {
    private WebDriver driver;
    By addCartBtn = By.xpath("//a[contains(@class,'btn-lg')]");
    By cartLink = By.xpath("//a[text()='Cart']");
    By homePage = By.cssSelector("a[href='index.html']");

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public Cart clickAddBtn(){
        driver.findElement(addCartBtn).click();
        WindowControl.acceptAlert(driver);
        driver.findElement(cartLink).click();
        return new Cart(driver);
    }

    public void clickAddForMultiple(){
        driver.findElement(addCartBtn).click();
        WindowControl.acceptAlert(driver);
        driver.findElement(cartLink).click();
        driver.findElement(homePage).click();
    }
}
