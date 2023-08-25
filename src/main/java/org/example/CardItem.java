package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardItem {
    public WebElement location;
    public WebElement price;
    public WebElement label;
    public WebElement description;
    static String textOfDescription;

    public CardItem(WebElement element) {
        setTheLocation(element);
        setThePrice(element);
        setDescription(element);
        setLabel(element);

    }

    private void setThePrice(WebElement elm) {
        try {
            price = elm.findElement(By.xpath(".//div[@class='p']"));
        } catch (NoSuchElementException e) {
            price = null;
        }

    }

    private void setTheLocation(WebElement elm) {
        try {
            location = elm.findElement(By.xpath(".//div[@class='at']"));
        } catch (NoSuchElementException e) {
            location = null;
        }

    }

    private void setDescription(WebElement elm) {
        try {
            description = elm.findElement(By.xpath(".//div[@class='l']"));
        } catch (NoSuchElementException e) {
            description = null;
        }
    }


    private void setLabel(WebElement elm) {
        try {
            label = elm.findElement(By.xpath(".//div[@class='l']"));
        } catch (NoSuchElementException e) {
            label = null;
        }
    }
}




