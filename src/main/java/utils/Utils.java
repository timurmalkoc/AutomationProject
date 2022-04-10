package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.slf4j.Log4jLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utils extends TestBase {
    public static String takeScreenshot(String testName){
        String destination = "screenshot/"+testName+".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File fileDestination = new File(destination);
            FileUtils.copyFile(screenshot,fileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
