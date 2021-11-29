package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {super(driver);}

    //*********Web Elements*********
    By usernameBy = By.id("txtUserName");
    By passwordBy = By.id("txtPassword");
    By pageMyAccount = By.id("myAccount");
    By pageLoginButtonBy = By.id("login");
    By loginButtonBy = By.id("btnEmailSelect");
    By nameLoginButtonBy = By.id("btnLogin");
    By errorMessageEmptyUsernameBy = By.xpath("//*/text()[normalize-space(.)='E-posta adresinizi veya telefon numaranızı girmelisiniz.']/parent::*");
    By errorMessageInvalidnameBy = By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]");
    By errorMessageInvalidPassBy = By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/div[4]/div/div/div/div[2]");
    By accountHepsiBuradaBy = By.xpath("//div[@id='myAccount']/span/a/span");

    //*********Page Methods*********

    public LoginPage loginHepsiBuradaUserName (String username) throws Exception{

        click(pageMyAccount);
        click(pageLoginButtonBy);
        //Enter Username(Email)
        writeText(usernameBy, username);
        click(nameLoginButtonBy);

        return this;
    }

    public LoginPage loginHepsiBuradaPassword (String password) throws Exception{

        //Enter Password
        writeText(passwordBy, password);
        //Click Login Button
        click(loginButtonBy);

        return this;
    }

    public LoginPage verifyLoginContainer (String expectedText) throws Exception{
        assertEquals(accountHepsiBuradaBy, expectedText);
        return this;
    }

    //Verify Username Condition
    public LoginPage verifyEmptyLoginUserName (String expectedText) throws  Exception {
        click(nameLoginButtonBy);
        assertEquals(errorMessageEmptyUsernameBy, expectedText);
        return this;
    }

    public LoginPage verifyInvalidLoginUserName (String expectedText) {
        assertEquals(errorMessageInvalidnameBy, expectedText);
        return this;
    }

    public LoginPage verifyInvalidLoginPass (String expectedText) {
        assertEquals(errorMessageInvalidPassBy, expectedText);
        return this;
    }
}
