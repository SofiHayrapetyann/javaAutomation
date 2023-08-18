package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResultPage {
    WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
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

    public List<WebElement> getAllItems() {
        List<WebElement> itemsOfApartment = driver.findElements(By.xpath("//a[contains(@href,'/item/')]"));
        List<WebElement> items = new ArrayList<>();
        for (int i = 0; i < itemsOfApartment.size(); i++) {
            items.add(itemsOfApartment.get(i));
        }
        return items;
    }

    public void elementToRemove() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        List<WebElement> itemsOfApartment = driver.findElements(By.xpath("//a[contains(@href,'/item/')]"));
        WebElement labelToDelete = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfNestedElementLocatedBy(itemsOfApartment.get(4), By.xpath(".//div[@class='clabel']")));
        js.executeScript("arguments[0].remove()", labelToDelete);

    }
}
