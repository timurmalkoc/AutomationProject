package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    WebDriver driver;
    By totalLocator = By.id("totalp");
    By fistItem = By.xpath("//tr/td[2]");
    By itemsPrices = By.xpath("//tr/td[3]");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotal(){
        return driver.findElement(totalLocator).getText();
    }

    public String getFirstItemInCart(){
        return driver.findElement(fistItem).getText();
    }

    public String getTotalOfList(){
        List<WebElement> price = driver.findElements(itemsPrices);
        String total = String.valueOf(price.stream().mapToInt(i-> Integer.parseInt(i.getText())).sum());
        System.out.println("total = "+ total);
        return total;
    }
}
