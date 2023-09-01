package list.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CardItem extends BaseComponents {
    private WebElement superElm;
    @FindBy(xpath = ".//div[@class='at']")
    private WebElement location;
    @FindBy(xpath = ".//div[@class='p']")
    private WebElement price;
    @FindBy(xpath = ".//div[@class='clabel']")
    private WebElement label;
    @FindBy(xpath = ".//div[@class='l']")
    private WebElement description;


    public CardItem(WebElement element) {
        super(element);

    }


    public WebElement getPrice() {
        return this.price;
    }


    public WebElement getLocation() {
        return this.location;
    }


    public WebElement getDescription() {
        return this.description;
    }


    public WebElement getLabel() {
        return this.label;
    }

    public boolean isLabelPresent() {
        try {
            superElm.findElement(By.xpath(".//div[@class='l']"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}




