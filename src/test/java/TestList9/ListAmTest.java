package TestList9;

import org.example.HomePageListAm;
import org.example.NotebooksPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ListAmTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void checkLastElementIsClickable() throws InterruptedException {
        HomePageListAm homePage = new HomePageListAm(driver);
        homePage.openDriver();
        homePage.clickElectronics();
        NotebooksPage result = new NotebooksPage(driver);
        Assert.assertTrue(result.isClickable());
    }

    @AfterClass
    public void quietDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


