package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) { super(driver); }

    //*********Page Variables*********

    String baseURL = "https://www.hepsiburada.com/";






    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToTestHepsiBurada () throws Exception {
        driver.get(baseURL);
        return this;
    }

}
