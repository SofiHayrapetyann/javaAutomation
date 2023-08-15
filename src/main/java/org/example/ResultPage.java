package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void filtersApartments(String category){
        WebElement buttonOfCategory=driver.findElement(By.xpath("//div[@id='menul']//div//label[text()='%s']".formatted(category)));
        buttonOfCategory.click();
    }
}
