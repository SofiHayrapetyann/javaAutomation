package TestList9;

import org.example.HomePageListAm;
import org.example.ResultPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ListAmTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void checkLastElementIsClickable() {
        HomePageListAm homePage = new HomePageListAm(driver);
        homePage.openDriver();
        homePage.changeLanguageToEnglish();
        homePage.hoverAndClick("Electronics", "Computers", "Notebooks");
        ResultPage lastElm = new ResultPage(driver);
        Assert.assertTrue(lastElm.checkIfLastElmisClickable(), "The last element is not clickable");
    }

    @Test
    public void checkIfAgencyLabelIsMissingOnItem() throws InterruptedException {
        HomePageListAm homePage = new HomePageListAm(driver);
        homePage.openDriver();
        homePage.changeLanguageToEnglish();
        homePage.hoverAndClick("Real Estate", "For Rent", "Apartments");
        ResultPage resultPage = new ResultPage(driver);
        resultPage.filtersApartments("Agency");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> itemsOfApartment = driver.findElements(By.xpath("//a[contains(@href,'/item/')]"));
        Thread.sleep(2000);
        WebElement labelToDelete=new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfNestedElementLocatedBy(itemsOfApartment.get(4),By.xpath(".//div[@class='clabel']")));
        js.executeScript("arguments[0].remove()", labelToDelete);
        for (WebElement elm : itemsOfApartment) {
            WebElement agencyLabel;
            WebElement descriptionOfElm = elm.findElement(By.xpath(".//div[@class='l']"));
            String textOfDescription = descriptionOfElm.getText();
            try {
                agencyLabel = elm.findElement(By.xpath(".//div[@class='clabel']"));
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("No such Element Exception" + textOfDescription);
            }
            Assert.assertEquals(agencyLabel.getText(), "Agency", textOfDescription + "This element does not contain Agency label");
        }

    }

    @AfterClass
    public void quietDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


