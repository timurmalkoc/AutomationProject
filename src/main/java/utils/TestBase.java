package utils;

import framework.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    private final static String dataProperties = "resources/data.properties";
    public HomePage homePage;


    public void setUp() throws MalformedURLException {
        ConfigsReader.readProperties(dataProperties);
        // local run
        // String browser = ConfigsReader.getProperty("browser");
        // jenkins
        String browser = System.getProperty("browser");

        if (browser.contains("chrome")) {
            if (browser.contains("remote")) {
                driver = new RemoteWebDriver(new URL(ConfigsReader.getProperty("remoteURL")), new ChromeOptions());

            } else {
                if (ConfigsReader.getProperty("browserOption").equalsIgnoreCase("headless")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                }
                System.setProperty("webdriver.chrome.driver",ConfigsReader.getProperty("chrome"));
                driver = new ChromeDriver();
            }
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ConfigsReader.getProperty("firefox"));
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("explorer")) {
            System.setProperty("webdriver.ie.driver", ConfigsReader.getProperty("explorer"));
            driver = new InternetExplorerDriver();
        } else
            throw new RuntimeException("driver is not specified in the data.properties file.");

        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigsReader.getProperty("implicit")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ConfigsReader.getProperty("pageLoad")), TimeUnit.SECONDS);
        driver.get(ConfigsReader.getProperty("landingPage"));
        driver.manage().window().fullscreen();

    }


    public void tearDown() {
        driver.quit();
    }
}
