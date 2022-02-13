package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.automation.utils.PropertyReader;

public class LogInPage extends Base_Page{

    @FindBy(id = "user-name")
    WebElement userNameBox;

    @FindBy(id = "password")
    WebElement passwordBox;

    @FindBy(id = "login-button")
    WebElement logInBtn;


    public void doLogin(){
        userNameBox.sendKeys(PropertyReader.getProperty("login.username"));
        passwordBox.sendKeys(PropertyReader.getProperty("login.password"));
        logInBtn.click();
    }

    public void verifyUserAtLoginPage(){
        Assert.assertTrue(userNameBox.isDisplayed(),"UserName field is Missing at login page");
        Assert.assertEquals(passwordBox, true, "Password box is missing at the login page");
    }


}
