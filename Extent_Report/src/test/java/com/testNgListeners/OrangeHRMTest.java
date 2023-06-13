package com.testNgListeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{


    @Test(testName = "OrangeHRM_Test")
    public void logIn_Test() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        By userName = By.xpath("//input[@name='username']");
        By pass = By.xpath("//input[@name='password']");
        By submit = By.xpath("//button[@type='submit']");

        driver.findElement(userName).sendKeys("Fahad");
        driver.findElement(pass).sendKeys("Fahad123");
        driver.findElement(submit).click();

        // failing intentionally
        Assert.assertEquals("Fahad", "Kader");



    }


    @Test(testName = "Dummy_Test")
    public void dummy_Test(){

        System.out.println("Test Passe");
    }
}
