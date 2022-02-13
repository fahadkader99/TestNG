package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TshirtPage extends Base_Page{

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement tShirtPageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tShirtAddToCartBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIconBtn;



    public void verifyUserIsAtT_shirtPage(){
        String actual = tShirtPageTitle.getText();
        String expected = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actual,expected,"T_Shirt detail title is miss-matching at the page");
    }

    public void clickOnAddToCartButtonT_shirt(){
        tShirtAddToCartBtn.click();
    }

    public void userClickOnCartIcon_tShirt(){
        cartIconBtn.click();
    }



}
