package setup;

import enums.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLoad {
    public static PageLoad pageLoad() {
        PageLoad pageLoad = new PageLoad();
        return pageLoad;
    }

    public PageLoad isElementClickable(By by) {
        try {
            new WebDriverWait(DriverHelper.getDriver(BrowserType.CHROME), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
            return this;
        } catch (WebDriverException e) {
        }
        return null;
    }

    public PageLoad isElementVisible(By by) {
        try {
            new WebDriverWait(DriverHelper.getDriver(BrowserType.CHROME), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (WebDriverException e) {
        }
        return null;
    }
}
