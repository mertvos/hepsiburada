package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver){super(driver);}


    //*********Web Elements*********
    By searchBarBy = By.xpath("//input[@value='']");
    By searchButtonBy = By.xpath("//div[@id='SearchBoxOld']/div/div/div[2]");
    By selectAProduct = By.id("i0");


    public ProductPage productPage(String search) throws Exception {
        writeText(searchBarBy, search);
        click(searchButtonBy);
        click(selectAProduct);
        return this;
    }


}
