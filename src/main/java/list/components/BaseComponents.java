package list.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseComponents {
    WebElement superElm;
    public BaseComponents(WebElement elm){
        this.superElm=elm;
        PageFactory.initElements(superElm,this);
    }
}
