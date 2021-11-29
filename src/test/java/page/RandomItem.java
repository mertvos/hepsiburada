package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomItem extends BasePage {


    public RandomItem(WebDriver driver) {super(driver);}

    //web element:



    public RandomItem randomItem() throws Exception{ //istenirse diğerleri gibi object pattern olabilir.
        List<WebElement> itemLinks = driver.findElements(By.tagName("li"));
        System.out.println("The Number Of item links in the page " +itemLinks.size());
        Random r = new Random();
        int randomItem = (r.nextInt(itemLinks.size()-1));
        itemLinks.get(randomItem).click();
        return this;

    }


}
