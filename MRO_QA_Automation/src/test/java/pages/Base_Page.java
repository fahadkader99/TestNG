package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.tests.Base_Test;

import java.util.concurrent.TimeUnit;

public abstract class Base_Page {

    WebDriver driver;
    WebDriverWait wait;

    Base_Page(){
        this.driver = Base_Test.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 8);
        PageFactory.initElements(driver, this);
    }
}
