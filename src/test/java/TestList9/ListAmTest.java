package TestList9;

import org.example.CardItem;
import org.example.HomePageListAm;
import org.example.ItemsOfApartment;
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
        resultPage.elementToRemove();
        CardItem items = new CardItem();
        Assert.assertTrue(items.isLabelPresent(resultPage.getAllItems()), items.getTextOfDescription());

    }

    @AfterClass
    public void quietDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


