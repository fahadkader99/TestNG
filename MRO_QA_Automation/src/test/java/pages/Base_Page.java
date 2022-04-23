package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.tests.Base_Test;

public abstract class Base_Page {

    WebDriver driver;
    WebDriverWait wait;

    Base_Page(){
        this.driver = Base_Test.driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
