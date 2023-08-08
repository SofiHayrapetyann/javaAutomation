package TestList9;

import org.example.HomePageListAm;
import org.example.NotebooksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ListAmTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void checkLastElementIsClickable() {
        HomePageListAm homePage = new HomePageListAm(driver);
        homePage.openDriver();
        homePage.clickElectronics();
        NotebooksPage lastElm = new NotebooksPage(driver);
        Assert.assertTrue(lastElm.isClickable(),"in case of false element is not clickable");
    }

    @AfterClass
    public void quietDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


