package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import static java.util.Objects.isNull;

public class LocalDriverFactory {

    private static WebDriver driver;
    private static String driverName;

    public static WebDriver getDriver() {
        driverName = System.getProperty("driver") == null ? "chrome" : System.getProperty("driver");
        if (driver == null) {
            switch (driverName) {
                case ("chrome"):
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case ("firefox"):
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
            driver.close();
            driver = null;
    }
}
