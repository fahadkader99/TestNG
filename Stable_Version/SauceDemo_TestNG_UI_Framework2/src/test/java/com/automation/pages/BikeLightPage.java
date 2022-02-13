package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BikeLightPage extends Base_Page{

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement pageLogo;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement bikeLightTitle;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightAddToCartBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;





    public void verifyUserAtBikeLightProductPage(){
        Assert.assertTrue(pageLogo.isDisplayed(),"Page logo is missing from Bike Light page");
        Assert.assertTrue(bikeLightTitle.isDisplayed(),"Bike Light Title is missing from the product page");
    }

    public void clickAddToCartButtonBikeLight(){
        bikeLightAddToCartBtn.click();
    }

    public void clickOnCartIcon_bikeLight(){
        cartIcon.click();
    }






}
