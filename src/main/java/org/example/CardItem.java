package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardItem {
    private static final By labelElm = By.xpath(".//div[@class='clabel']");
    static String textOfDescription;
    public CardItem(WebElement element){

    }
    public void checkSomeConditions(WebElement elm){
       WebElement locationOfElm= elm.findElement(By.xpath(".//div[@class='at']"));
       WebElement priceOfElm=elm.findElement(By.xpath(".//div[@class='p']"));
        String location=locationOfElm.getText().split(",")[0];
        String[] stringOfPrice=priceOfElm.getText().split(" ")[0].split(",");
        int price=Integer.parseInt(stringOfPrice[0]+stringOfPrice[1]);
        String currency=priceOfElm.getText().split(" ")[1];

    }

    public static boolean isLabelPresent(List<WebElement> itemsOfApartment) {
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

//    public String getTextOfDescription() {
//        return textOfDescription;
//    }
}
