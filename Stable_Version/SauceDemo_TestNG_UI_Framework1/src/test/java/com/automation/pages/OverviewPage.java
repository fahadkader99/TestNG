package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OverviewPage {

    @FindBy(xpath = "//span[@class='title']")
    WebElement overViewPageTitle;

    @FindBy(className = "cart_desc_label")
    WebElement productDescription;

    @FindBy(className = "summary_info_label")
    WebElement shippingInfo;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishBtn;




    WebDriver driver;
    public OverviewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void verifyOverViewPage(){
        Assert.assertTrue(overViewPageTitle.isDisplayed(),"Overview page title is missing");
        Assert.assertTrue(productDescription.isDisplayed(),"Overview description is not matching.");
        Assert.assertTrue(shippingInfo.isDisplayed(),"Shipping info is not displayed in Overview page");
    }

    public void clickFinishButton(){
        finishBtn.click();
    }








}
