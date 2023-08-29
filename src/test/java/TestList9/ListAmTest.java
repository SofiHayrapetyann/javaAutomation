package TestList9;

import list.components.CardItem;
import org.example.HomePageListAm;
import org.example.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class ListAmTest extends  BaseTest{
    @Test
    public void checkLastElementIsClickable() {
        HomePageListAm homePage = new HomePageListAm(driver).get();
        homePage.hoverAndClick("Electronics", "Computers", "Notebooks");
        ResultPage lastElm = new ResultPage(driver);
        Assert.assertTrue(lastElm.checkIfLastElmisClickable(), "The last element is not clickable");
    }

    @Test
    public void checkIfAgencyLabelIsMissingOnItem() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        HomePageListAm homePage = new HomePageListAm(driver).get();
        homePage.hoverAndClick("Real Estate", "For Rent", "Apartments");
        ResultPage resultPage = new ResultPage(driver);
        resultPage.filtersApartments("Agency");
        resultPage.elementToRemove();
        for (CardItem item : resultPage.getAllItems()) {
            String descriptionOfElm = item.getDescription().getText();
            softAssert.assertEquals(item.isLabelPresent(), "The label is misising" + descriptionOfElm);
        }
        softAssert.assertAll();

    }

    @Test
    public void checkIfSomeFiltersWorkRight() throws InterruptedException {
        HomePageListAm homePage = new HomePageListAm(driver).get();

        homePage.hoverAndClick("Electronics", "Computers", "Notebooks");
        ResultPage resultPage = new ResultPage(driver);
        resultPage.chooseDropDownField("Location", "Kentron");
        resultPage.chooseDropDownField("Currency", "AMD");
        resultPage.addInputFilter("Price", "200000", "500000");

        for (CardItem item : resultPage.getAllItems()) {
            String[] stringOfPrice = item.getPrice().getText().split(" ")[0].split(",");
            int price = Integer.parseInt(stringOfPrice[0] + stringOfPrice[1]);
            Thread.sleep(30000);
            String currency = item.getPrice().getText().split(" ")[1];
            String location = item.getLocation().getText().split(",")[0];
            SoftAssert softAssert = new SoftAssert();

            softAssert.assertEquals(location, "Kentron");
            softAssert.assertEquals(currency, "֏");
            softAssert.assertTrue(price >= 200000 & price <= 500000);
            softAssert.assertAll();


        }
    }


}


