package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResultPage extends BasePageList {
   private static final By ITEMS= By.xpath("//a[contains(@href,'/item/')]");

    private final String xPathOfFieldDropDown = "//div[@class='filter']//form//div[text()='%s' ]/following-sibling::div";
    private final String xPathOfInputFilter = "//div[@id='menul']//div[@class='at']//div[text()='%s']/following-sibling::div";

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfLastElmisClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement lastElm = driver.findElement(By.xpath("(//div[@class='gl']//a)[last()]"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].scrollIntoView(true);", lastElm);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lastElm));
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable");
            return false;
        }
        return true;
    }

    public void filtersApartments(String category) {
        WebElement buttonOfCategory = driver.findElement(By.xpath("//div[@id='menul']//div//label[text()='%s']".formatted(category)));
        buttonOfCategory.click();
    }

    public void chooseDropDownField(String nameOfDropDownFile, String nameOfLocation) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement buttonOfDropDownField = driver.findElement(By.xpath(xPathOfFieldDropDown.formatted(nameOfDropDownFile)));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(buttonOfDropDownField, (By.xpath(".//div[@class='me']")))).click();
        buttonOfDropDownField.findElement(By.xpath(".//div[contains(@class,'l')]/div[contains(text(),'%s')]".formatted(nameOfLocation))).click();
        Thread.sleep(3000);
    }

    public void addInputFilter(String inputFilter, String inputFrom, String inputTo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement inputField = driver.findElement(By.xpath(xPathOfInputFilter.formatted(inputFilter)));
        WebElement input1 = inputField.findElement(By.xpath(".//input[1]"));
        input1.sendKeys(inputFrom);
        WebElement input2 = inputField.findElement(By.xpath(".//input[2]"));
        input2.sendKeys(inputTo);
        wait.until(ExpectedConditions.elementToBeClickable(wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(inputField, By.xpath(".//a"))))).click();
    }


    public List<CardItem> getAllItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        List<WebElement> itemsOfApartment = driver.findElements(ITEMS);
        List<CardItem> items = new ArrayList<>();
        for (int i = 0; i < itemsOfApartment.size(); i++) {
            items.add(new CardItem(itemsOfApartment.get(i)));
        }
        return items;
    }

    public void elementToRemove() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        List<WebElement> itemsOfApartment = driver.findElements(ITEMS);
        WebElement labelToDelete = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfNestedElementLocatedBy(itemsOfApartment.get(4), By.xpath(".//div[@class='clabel']")));
        js.executeScript("arguments[0].remove()", labelToDelete);
    }
}
