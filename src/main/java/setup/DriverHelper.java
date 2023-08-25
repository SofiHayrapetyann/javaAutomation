package setup;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverHelper {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver driver = DRIVER_THREAD_LOCAL.get();
        if (driver == null) {
            switch (browserType) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case SAFARI -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new SafariDriver();
                }
            }
        }
        return driver;
    }
}