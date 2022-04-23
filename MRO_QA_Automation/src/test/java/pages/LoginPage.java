package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.tests.Base_Test;
import test.java.utils.Property_Reader;

public class LoginPage extends Base_Page{

    @FindBy(id = "UserName")
    private WebElement userName;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "Client")
    private WebElement client;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement logOnBtn;



    public void doLogin(){
        Base_Test.logger.info("User entered username ");
        userName.sendKeys(Property_Reader.getProperty("userID"));
        Base_Test.logger.info("User entered password ");
        password.sendKeys(Property_Reader.getProperty("psw"));
        Base_Test.logger.info("User entered client ID ");
        client.sendKeys(Property_Reader.getProperty("client"));
    }

    public void click_logOnBtn(){
        Base_Test.logger.info("User clicked login button ");
        logOnBtn.click();
    }



}
