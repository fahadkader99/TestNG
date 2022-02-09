package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    @FindBy(className = "app_logo")
    WebElement cartPageLogo;

    @FindBy(xpath = "//span[@class='title']")
    WebElement cartPageTitle;

    @FindBy(id = "checkout")
    WebElement checkOutBtn;


   WebDriver driver;
   public CartPage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

   public void verifyUserOnCartPage(){
       Assert.assertTrue(cartPageLogo.isDisplayed(),"Cart page logo is missing ");
       Assert.assertTrue(cartPageTitle.isDisplayed(),"User is not at cart page yet. ");
       Assert.assertEquals(cartPageTitle.isDisplayed(),true,"User is not at cart page yet.");
       // true and equal is almost same, it is just different way of representation.
   }


   public void clickOnCheckoutButton(){
       checkOutBtn.click();
   }


}
