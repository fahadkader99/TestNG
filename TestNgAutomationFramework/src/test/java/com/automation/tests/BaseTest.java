package com.automation.tests;
// this class will have all the codes which will be reused.

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    WebDriver driver;

    LoginPage loginpage;
    HomePage homePage ;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(59));
        driver.get("http://www.saucedemo.com/");

        loginpage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}
