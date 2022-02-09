package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends Base_Page {

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement homePageLogo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homePageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Bike Light')]")
    WebElement bikeLightLink;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Bolt T-Shirt')]")
    WebElement T_shirtLink;



    public void verifyUserAtHomePage(){
        Assert.assertTrue(homePageLogo.isDisplayed(),"Home page logo is not displayed");
        Assert.assertTrue(homePageTitle.isDisplayed(),"Home page title is not displayed");
    }

    public void clickOnItemBikeLight(){
        bikeLightLink.click();
    }

    public void clickOnItemT_shirt(){
        T_shirtLink.click();
    }


}
