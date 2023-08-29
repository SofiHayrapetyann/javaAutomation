package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageListAm extends BasePageList<HomePageListAm> {
    private final String BASE_URL = "https://www.list.am/";
    private static final By ITEMS = By.xpath("//a[contains(@href,'/item/')]");

    public HomePageListAm(WebDriver driver) {
        super(driver);
    }

    private  void changeLanguagePopUpMenu (String language) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        if (!(language.equals("en") || language.equals("ru") || language.equals("am"))) {
            throw new IllegalArgumentException("Invalid input: " + language);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dlgLangSel']//a[@href='/%s/']".formatted(language)))).click();

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
public void changeLanguageTo(String language){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
if(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dlgLangSel"))).size()!=0){
    changeLanguagePopUpMenu(language);

}
    }
@Override
protected void load(){
        open();
        changeLanguageTo("en");
}
@Override
    protected void isLoaded(){
        if(driver.findElements(ITEMS).size()==0){
            throw new Error("The page is not loaded");
        }
        if(driver.getCurrentUrl().contains(BASE_URL)){
            throw new Error("The page is not loaded");
        }

}

}
