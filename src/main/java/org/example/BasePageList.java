package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePageList {
    WebDriver driver;
    final static String BASE_URL = "https://www.list.am";
    String footerButton = "//div[@id='pfooter']//div[@class='r']/a[text()='%s']";

    public BasePageList(WebDriver driver) {
        this.driver = driver;

    }
    public void open() {
        driver.get(BASE_URL);
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

}
