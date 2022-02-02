package com.automation.pages;

import com.automation.tests.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement userNameEle;

    @FindBy(id = "password")
    WebElement passwordEle;

    @FindBy(id = "login-button")
    WebElement logInBtn;



    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void doLogin(){
        // login in
        userNameEle.sendKeys("standard_user");
        passwordEle.sendKeys("secret_sauce");
        logInBtn.click();
    }
    public void verifyLoginPage(){
//        WebElement userNameEle = driver.findElement(By.id("user-name"));
//        WebElement passwordEle = driver.findElement(By.id("password"));
        Assert.assertTrue(userNameEle.isDisplayed(),"Username input is missing from login page");
        Assert.assertTrue(passwordEle.isDisplayed(),"Password input is missing from login page");
    }
}
