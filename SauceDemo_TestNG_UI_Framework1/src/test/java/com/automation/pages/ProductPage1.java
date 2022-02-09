package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage1 {

    @FindBy(className = "app_logo")
    WebElement productPageLogo;

    @FindBy(xpath = "//img[@alt='Sauce Labs Backpack']")
    WebElement backpackImage;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon1;

    WebDriver driver;
    public ProductPage1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyProduct1DetailPage(){
        Assert.assertTrue(productPageLogo.isDisplayed(),"Product logo is missing from product1 page");
        Assert.assertTrue(backpackImage.isDisplayed(),"Backpack image is missing from product1 page");
    }

    public void clickAddToCartButtonProduct1(){
        addToCartBtn.click();
    }

    public void clickOnCartIcon1(){
        cartIcon1.click();
    }




}
