package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.tests.Base_Test;

public abstract class Base_Page {

    WebDriver driver;

    Base_Page(){
        this.driver = Base_Test.driver;
        PageFactory.initElements(driver, this);
    }
}
