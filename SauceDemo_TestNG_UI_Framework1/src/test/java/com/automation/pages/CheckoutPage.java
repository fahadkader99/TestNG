package com.automation.pages;

import com.automation.utils.DataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(id = "first-name")
    WebElement firstNameBox;

    @FindBy(id = "last-name")
    WebElement lastNameBox;

    @FindBy(id = "postal-code")
    WebElement zipCodeBox;

    @FindBy(id = "continue")
    WebElement continueBtn;



    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void fillOutCheckoutDetail(){
        firstNameBox.sendKeys(DataReader.getProperty("user.firstname"));
        lastNameBox.sendKeys(DataReader.getProperty("user.lastname"));
        zipCodeBox.sendKeys(DataReader.getProperty("user.zipcode"));
    }

    public void clickContinueButton(){
        continueBtn.click();
    }


}
