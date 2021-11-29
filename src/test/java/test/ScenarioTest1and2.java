package test;
import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
public class ScenarioTest1and2 extends BaseTest {


    @Test(priority = 0)
    public void goHomePage() throws Exception {

        setUp("FİREFOX");
        HomePage homePage = new HomePage(driver);
        homePage.goToTestHepsiBurada(); //www.hepsiburada.com sitesi açılır.

    }

    @Test(priority = 1)//invalid login
    public void invalidLoginTestEmptyUserName() throws Exception {
        goHomePage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginHepsiBuradaUserName("");
        loginPage.verifyEmptyLoginUserName("E-posta adresinizi veya telefon numaranızı girmelisiniz.");
        // logTest.info(loginPage.verifyLoginContainer(driver.getTitle()) + "Hesaba Giriş Yapıldı");
    }

    @Test(priority = 1)//invalid login
    public void invalidLoginTestInvalidUserName() throws Exception {
        goHomePage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginHepsiBuradaUserName("12341211@12341.com");
        loginPage.verifyInvalidLoginUserName("E-posta adresi eksik veya hatalı.");
        // logTest.info(loginPage.verifyLoginContainer(driver.getTitle()) + "Hesaba Giriş Yapıldı");
    }

    @Test(priority = 1)//invalid login
    public void invalidLoginTestInvalidPassword() throws Exception {
        goHomePage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginHepsiBuradaUserName("mertcandogan1234@gmail.com");
        loginPage.loginHepsiBuradaPassword("invalidpass");
        loginPage.verifyInvalidLoginPass("Girdiğiniz şifre eksik veya hatalı.");
        // logTest.info(loginPage.verifyLoginContainer(driver.getTitle()) + "Hesaba Giriş Yapıldı");
    }

    @Test(priority = 2)//valid login
    public void validLoginTest() throws Exception {
        goHomePage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginHepsiBuradaUserName("mertcandogan1234@gmail.com");
        loginPage.loginHepsiBuradaPassword("otomasyoN1");
        loginPage.verifyLoginContainer("Hesabım");
        logTest.info("Hesaba Giriş Yapıldı");
    }

    @Test(priority = 2)
//search and click product //ps: if you want random click to product links, you will comment selectAProduct function and add a RandomItem page codes.
    public void searchProductWithLogin() throws Exception {
        validLoginTest();
        ProductPage productPage = new ProductPage(driver);
        productPage.productPage("HBCV00000SOH2C"); //if you want random click to product links, you must search generic words like kulaklık
    }

    @Test(priority = 2)// fullrun scenario1
    public void addToChart() throws Exception {
        searchProductWithLogin();
        ChartPage chartPage = new ChartPage(driver);
        chartPage.chartPage();

    }

    // Scenario 2
    @Test(priority = 2)
    public void searchProductWithOutLogin() throws Exception {
        goHomePage();
        ProductPage productPage = new ProductPage(driver);
        productPage.productPage("HBCV00000SOH2C"); //if you want random click to product links, you must search generic words like kulaklık
    }
    @Test(priority = 2)// fullrun scenario2
    public void addToChartNoLogin() throws Exception {
        searchProductWithOutLogin();
        ChartPage chartPage = new ChartPage(driver);
        chartPage.chartPage();

    }


}
