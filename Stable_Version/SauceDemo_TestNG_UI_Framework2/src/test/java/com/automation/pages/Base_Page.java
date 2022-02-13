package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.automation.utils.DriverUtils;

public abstract class Base_Page {

    WebDriver driver;

    Base_Page(){
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(driver,this);
    }

}
