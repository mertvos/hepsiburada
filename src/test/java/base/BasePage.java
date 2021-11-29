package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.BaseTest;


public class BasePage {
    protected static final org.apache.log4j.Logger logTest = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    protected WebDriverWait wait;
    private static String chartName;

    //scroll
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //Constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Click Method
    public void click (By elementBy) throws Exception {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }


    //Write Text
    public void writeText (By elementBy, String text) throws Exception {
        //waitVisibility(elementBy);
        //driver.findElement(elementBy).click();
        //driver.findElement(elementBy).clear();
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
        Thread.sleep(1500); //not necessary
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void scrollAndClick (By elementBy) throws Exception{

        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitVisibility(elementBy);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(elementBy));
        waitVisibility(elementBy);
        Thread.sleep(3000);
        driver.findElement(elementBy).click();

    }

    public void switchWindow () throws Exception{
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public String storeTextChart () throws Exception{
        Thread.sleep(2500);
        String chartProductName = (String)driver.findElement(By.id("product-name")).getText();
       System.out.println(chartProductName);
       chartName = chartProductName;
       return chartProductName;

    }

    public String storeTextBasket () throws Exception{

        Thread.sleep(2500);
        String basketProductName = (String)driver.findElement(By.cssSelector("div.product_name_3Lh3t > a")).getText();
        System.out.println(basketProductName);
        return basketProductName;

    }

    public void compareProducts() throws Exception {
        storeTextBasket();
        //storeTextChart();
        if(storeTextBasket().equals(chartName)){
            logTest.info("Aynı üründür." + chartName);
        }
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }


}
