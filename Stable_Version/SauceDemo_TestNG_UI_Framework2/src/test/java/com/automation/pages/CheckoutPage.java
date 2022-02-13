package com.automation.pages;


import com.automation.utils.PropertyReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends Base_Page{

    @FindBy(id = "first-name")
    WebElement firstNameBox;

    @FindBy(id = "last-name")
    WebElement lastNameBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeBox;

    @FindBy(id = "continue")
    WebElement continueBtn;




    public void fillOutCheckoutDetail(){
        firstNameBox.sendKeys(PropertyReader.getProperty("user.firstname"));
        lastNameBox.sendKeys(PropertyReader.getProperty("user.lastname"));
        zipCodeBox.sendKeys(PropertyReader.getProperty("user.zipcode"));
    }

    public void clickContinueButton(){
        continueBtn.click();
    }


}
