/*
package com.automation.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base_Test implements ITestListener {

    // Note: when even test fails these listeners methods will be executed as per the action of the methods

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // This method will be executed when the test fails.
        String testMethodName = iTestResult.getMethod().getMethodName();    // getting the methodName which will fail




        // one time use in the framework;
        WebDriver driver = null;
        try {
            driver = (WebDriver)iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstanceName());
        }catch (Exception e){
            System.out.println("Exception found on Listeners: "+ e);
        }




        // now will pass the ScreenShot method here
        try {
            getScreenShotPath(testMethodName, driver);
        } catch (IOException e) {
            System.out.println("Error detected on Listeners class:: for ScreenShot...!");
        }


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
*/
