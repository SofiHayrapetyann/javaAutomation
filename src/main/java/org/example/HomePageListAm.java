package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageListAm {
    private final WebDriver driver;
    private final String BASE_URL = "https://www.list.am/";
    private final String element = "//div[@id='menu']//div/a[text()='Electronics']";

    public HomePageListAm(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElectronics() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement language = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bar']//a[@href='/en/']")));//change the language
        language.click();
        By tabLocator = By.xpath("//div[@id='menu']//div/a[text()='Electronics']");
        WebElement electronics = driver.findElement(tabLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pane']//div//a[text()='Notebooks']"))).click();

    }

    public void openDriver() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }
}
