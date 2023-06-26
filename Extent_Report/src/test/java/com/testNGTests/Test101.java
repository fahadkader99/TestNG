package com.testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testNgListeners.BaseTest;
import com.testNgReporter.ReportTestManager;
import com.testNgReporter.TestListener2;

@Listeners(TestListener2.class)

public class Test101 extends BaseTest{

	 @Test(testName = "testGoogle",  priority = 0, description = "TC 101")
	    public void testGoogle() throws Exception{
	    	

	    	//Listener.extentTest.info("Testing started");
	    	ReportTestManager.logText("starting Test 1");
	    	
	        driver.get("https://www.google.com/");
	        Thread.sleep(1000); 
	        driver.findElement(By.name("q")).sendKeys("HYR Tutorials");
	        String expectedTitle = "HYR Tutorials - Google Search";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Title is miss-matched");

	    }

	    @Test(testName = "testFacebook", priority = 1, description = "TC 102")
	    public void testFacebook() throws Exception{
	    	
	    	//Listener.extentTest.info("Testing started");
	    	ReportTestManager.logText("starting Test 2");
	    	
	        driver.get("https://www.facebook.com/");
	        Thread.sleep(1000);
	        driver.findElement(By.name("email")).sendKeys("Fahad Kader");
	        SoftAssert softAssert = new SoftAssert();

	        // title assertion
	        String expectedTitle = "Log in to Facebook";
	        String actualTitle = driver.getTitle();
	        softAssert.assertEquals(actualTitle, expectedTitle, "Title miss-matched");

	        // URL assertion
	        String actualURL = driver.getCurrentUrl();
	        String expectedURL = "Https://www/facebook.com/";
	        softAssert.assertEquals(actualURL, expectedURL, "URL miss-matched");


	    }

	    @Test(testName = "testOrangeHRM", priority = 2, groups = {"SMOKE"}, description = "TC 103")
	    public void testOrangeHRM() throws Exception{
	    	
	    	//Listener.extentTest.info("Testing started");
	    	ReportTestManager.logText("starting Test 3");
	    	
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Welcome to Orange HRM";
	        Assert.assertTrue(actualTitle.equals(expectedTitle), "Title miss-matched");

	    }
	    
	    @Test(testName = "testNaveenAutomation", priority = 3, description = "TC 444", dependsOnMethods = {"testOrangeHRM"})
	    public void testNaveenAutomation() throws InterruptedException {
	    	
	    	ReportTestManager.logText("starting Test 4");
	    	
	        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	        Thread.sleep(1000);

	        By emailID = By.id("input-email");
	        By password = By.id("input-password");
	        By login = By.xpath("//input[@type='submit']");

	        /*
	        Action.sendKeys() is better > since it will click at the middle of the element & then it will send the text value.
	        Action.moveToElement().click() > also better then driver.click
	         */

	        Actions actions = new Actions(driver);
	        actions.sendKeys(driver.findElement(emailID), "test@gmail.com").perform();
	        Thread.sleep(500);
	        actions.sendKeys(driver.findElement(password), "test@123").perform();
	        actions.click(driver.findElement(login)).perform();
	        
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, "My Account", "Title miss-matched");
	    }
	    
	    // Note - all the test class should have Test at the end of the name > only then maven will run them automatically

}
