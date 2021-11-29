package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChartPage extends BasePage {

    public ChartPage(WebDriver driver){super(driver);}


    //*********Web Elements*********

    By selectItemByFirstSeller = By.id("addToCart");
    By selectItemBySecondSeller = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='alfatek'])[1]/preceding::button[1]");
    By popupCloseBy = By.cssSelector("a.checkoutui-Modal-2iZXl > svg > g > g > g > g > g > g > path");
    By goToBasketBy = By.id("shoppingCart");

    public ChartPage chartPage () throws Exception{

        switchWindow();
        storeTextChart();
        scrollAndClick(selectItemByFirstSeller);
        scrollAndClick(popupCloseBy);
        scrollAndClick(selectItemBySecondSeller);
        scrollAndClick(popupCloseBy);
        click(goToBasketBy);
        storeTextBasket();
        compareProducts();
        return this;

    }

}
