package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardItem {
    private final By labelElm = By.xpath(".//div[@class='clabel']");
    String textOfDescription;

    public boolean isLabelPresent(List<WebElement> itemsOfApartment) {
        int a = 0;
        for (WebElement elm : itemsOfApartment) {
            WebElement agencyLabel;
            WebElement descriptionOfElm = elm.findElement(By.xpath(".//div[@class='l']"));
            textOfDescription = descriptionOfElm.getText();
            try {
                agencyLabel = elm.findElement(labelElm);
            } catch (NoSuchElementException e) {
                System.out.println(textOfDescription);
                return false;
            }
        }
        return true;
    }

    public String getTextOfDescription() {
        return textOfDescription;
    }
}
