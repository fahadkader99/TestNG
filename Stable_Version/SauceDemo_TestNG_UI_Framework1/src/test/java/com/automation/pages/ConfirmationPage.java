package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {

    @FindBy(className = "title")
    WebElement completeTitle;

    @FindBy(className = "complete-header")
    WebElement confirmationTitle;

    @FindBy(className = "complete-text")
    WebElement orderCompleteText;


    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void verifyOrderConfirmationPage(){
        Assert.assertTrue(completeTitle.isDisplayed(),"Complete title is missing from confirmation page");

        String actual = confirmationTitle.getText();
        String expected = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);

    }


    public void printOderCompleteMessage(){
        System.out.println("\n\n"+orderCompleteText.getText());
    }



}
