package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    @FindBy(className = "app_logo")
    WebElement homePageLogo;

    @FindBy(css = ".title")
    WebElement homePageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

     @FindBy(id = "logout_sidebar_link")
     WebElement logoutLink;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyHomePage(){
        // To verify the login is successfully

        // checking the condition
        Assert.assertTrue(homePageLogo.isDisplayed(),"Logo is missing from homepage");
        Assert.assertTrue(homePageTitle.isDisplayed(),"Title is missing from homepage");
    }
    public void clickBurgerMenu(){

        burgerMenu.click();
    }
    public void clickLogoutLink(){

        logoutLink.click();


    }
}
