package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NotebooksPage {
    WebDriver driver;

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href,'/en/item/')]"));
        WebElement lastElm = elements.get(elements.size() - 1);
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].scrollIntoView(true);", lastElm);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lastElm));
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element is not clickable");
            return false;
        }
        return true;
    }
}
