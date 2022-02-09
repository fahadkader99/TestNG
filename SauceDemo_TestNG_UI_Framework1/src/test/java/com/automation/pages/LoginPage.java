package com.automation.pages;

import com.automation.utils.DataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement login;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;


    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void doLogin(){
        login.sendKeys(DataReader.getProperty("login.username"));
        password.sendKeys(DataReader.getProperty("login.password"));
        loginBtn.click();
    }


    public void verifyUserAtLoginPage(){
        Assert.assertTrue(login.isDisplayed(), "Username input is missing from login page ");
        Assert.assertTrue(password.isDisplayed(), "Password input is missing from the login page");
    }










}
