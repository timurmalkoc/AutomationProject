package framework;

import com.mysql.cj.xdevapi.UpdateResultBuilder;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    public WebDriver driver;
    By totalLocator = By.id("totalp");
    By fistItem = By.xpath("//tr/td[2]");
    By itemsPrices = By.xpath("//tr/td[3]");
    By deleteLink = By.xpath("//a[text()='Delete']");
    By placeOrderBtn = By.cssSelector(".btn-success");
    By nameBox = By.id("name");
    By countryBox = By.id("country");
    By cityBox = By.id("city");
    By creditCart = By.id("card");
    By monthBox = By.id("month");
    By yearBox = By.id("year");
    By purchaseBtn = By.xpath("//div[@class='modal-footer']/button[text()='Purchase']");
    By successMsg = By.xpath("//div[contains(@class,'alert')]/h2");

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
        System.out.println("items = ");
        price.stream().map(i->i.getText()).collect(Collectors.toList()).forEach(System.out::println);
        String total = String.valueOf(price.stream().mapToInt(i-> Integer.parseInt(i.getText())).sum());
        System.out.println("total = "+ total);
        return total;
    }

    @SneakyThrows
    public int getTotalNumberOfItem(){
        Thread.sleep(500);
        return driver.findElements(itemsPrices).size();
    }

    public void deleteItem(){
        driver.findElement(deleteLink).click();
    }

    public void refreshCartPage(){
        driver.navigate().refresh();
    }
    public void clickPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
    }
    public void fillPurchaseForm(String name, String country, String city, String card, String month, String year){
    driver.findElement(nameBox).sendKeys(name);
    driver.findElement(countryBox).sendKeys(country);
    driver.findElement(cityBox).sendKeys(city);
    driver.findElement(creditCart).sendKeys(card);
    driver.findElement(monthBox).sendKeys(month);
    driver.findElement(yearBox).sendKeys(year);
    driver.findElement(purchaseBtn).click();
    }

    public String successMsg(){
        return driver.findElement(successMsg).getText();
    }

}
