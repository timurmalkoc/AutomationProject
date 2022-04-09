package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WindowControl{

    public static boolean isAlertPresent(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,2);
        boolean result = true;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e){
            result = false;
        }
            return result;
    }

    public static void acceptAlert(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }
}
