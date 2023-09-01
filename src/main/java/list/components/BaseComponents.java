package list.components;

import com.google.common.primitives.Ints;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BaseComponents {
    public static void main(String[] args){
      int[] array = {4,5,6,7,2,3};
        for ( int i = 0; i < array.length; i++) {
            int z = 5 - array[i];
            if( Ints.contains(array,z)){
                System.out.println(array[i] + 5);
            }

        }

        List<Integer> array2 = new ArrayList<>();
        array2.add(4);
        array2.add(4);
        array2.add(5);
        for (int i = 0; i < array2.size(); i++) {
            for (int j = i+1; j < array2.size(); j++) {


            }
        }
    }
    WebElement superElm;
    public BaseComponents(WebElement elm){
        this.superElm=elm;
        PageFactory.initElements(superElm,this);
    }
}
