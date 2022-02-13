package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement homePageLogo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homePageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLinkBtn;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Backpack')]")
    WebElement backpackLink;




    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyUserAtHomePage(){
        Assert.assertTrue(homePageLogo.isDisplayed(),"Home page logo is not displayed");
        Assert.assertTrue(homePageTitle.isDisplayed(),"Home page title is not displayed");
    }

    public void clickOnBurgerMenu(){
        burgerMenuBtn.click();
    }

    public void clickLogOutBtn(){
        logoutLinkBtn.click();
    }

    public void clickOnBackPack(){
        backpackLink.click();
    }





}
