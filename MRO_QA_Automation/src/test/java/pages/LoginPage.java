package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        userName.sendKeys(Property_Reader.getProperty("userID"));
        password.sendKeys(Property_Reader.getProperty("psw"));
        client.sendKeys(Property_Reader.getProperty("client"));
    }

    public void click_logOnBtn(){
        logOnBtn.click();
    }



}
