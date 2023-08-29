package TestList9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void beforeRun() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public void afterTestEnds() {
        driver.close();
    }


    @AfterSuite
    public void quietDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}