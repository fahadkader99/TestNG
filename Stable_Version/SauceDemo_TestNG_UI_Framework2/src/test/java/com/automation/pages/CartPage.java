package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends Base_Page{

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement pageLogo;

    @FindBy (xpath = "//span[@class='title']")
    WebElement cartPageTitle;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='cart_item']")
    List<WebElement> listOfCartItems;



    public void verifyUserIsAtCartPage(){
        Assert.assertTrue(pageLogo.isDisplayed(),"Page logo is missing from the cart page");
        String actual = cartPageTitle.getText();
        String expected = "YOUR CART";
        Assert.assertEquals(actual,expected,"Cart page title is miss-matching");
    }

    public void userClickOnContinueShoppingButton(){
        continueShoppingBtn.click();
    }

    public void verifyTwoItemDisplayedOnCart(){
        int actualSize = listOfCartItems.size();
        int expectedSize = 2;
        Assert.assertEquals(actualSize,expectedSize,"Cart Items are not matching up at the final cart page. ");


    }

    public void clickOnCheckOutButton(){
        checkoutBtn.click();
    }


}
