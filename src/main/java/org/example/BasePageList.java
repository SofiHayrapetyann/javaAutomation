package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.DriverHelper;

import static setup.DriverHelper.getDriver;

public class BasePageList<T extends LoadableComponent<T>>extends LoadableComponent<T> {
    WebDriver driver;
    final static String BASE_URL = "https://www.list.am";
    String footerButton = "//div[@id='pfooter']//div[@class='r']/a[text()='%s']";

    public BasePageList(WebDriver driver) {
        this.driver = driver;
    }

    protected void open() {
        getDriver().get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void openHelp() {
        driver.findElement(By.xpath(footerButton.formatted("Help"))).click();
    }

    public void openContactUs() {
        driver.findElement(By.xpath(footerButton.formatted("ContactUs"))).click();
    }

    public void openTermsOfService() {
        driver.findElement(By.xpath(footerButton.formatted("TermsOfService"))).click();
    }


    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
