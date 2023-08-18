package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageListAm extends BasePageList {
    private final String BASE_URL = "https://www.list.am/";

    public HomePageListAm(WebDriver driver) {
        super(driver);
    }

    public void changeLanguageToEnglish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement language = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bar']//a[@href='/en/']")));
        language.click();

    }

    public void hoverAndClick(String category, String subCategory, String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        By tabLocator = By.xpath("//div[@id='menu']//div/a[text()='%s']".formatted(category));
        WebElement electronics = driver.findElement(tabLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div[@id='menu']//div[@class='pane']//b[text()='%s']" +
                "/following-sibling::div/a[text()='%s']").formatted(subCategory, item)))).click();
    }


    public void open() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }
}
