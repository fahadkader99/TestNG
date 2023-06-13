package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScreenShots_4 {
    static WebDriver driver;




    @Test
    public static void screenShots_TestLeve() throws Exception{

        driver = new ChromeDriver();

        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";

        // setting up extent report engine + creating spark report instance
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
        extentReports.attachReporter(sparkReporter);

        driver.get("https://www.google.com/");



        /*
        Test Level screenshots
        Selenium can capture screenshot in 3 ways > File, Base64 string & Byte array
         */

        // 1st using Base64 string
        String base54 = takeScreenShot();

        extentReports.createTest("ScreenShot Test 1", "This is for attaching the screenshot to the test at test level")
                .info("This is a info msg")
                        .addScreenCaptureFromBase64String(base54);


        extentReports.createTest("ScreenShot Test 2", "This is for attaching the screenshot to the test at test level + title")
                .info("This is a info msg")
                .addScreenCaptureFromBase64String(base54, "Google with Base64");            // better!



        // 2nd using string path
        String path = takeScreenShot("google.jpg");
        extentReports.createTest("ScreenShot Test 3", "This is for attaching the screenshot to the test at test level with String path")
                .info("This is a info msg")
                .addScreenCaptureFromPath(path);


        extentReports.createTest("ScreenShot Test 4", "This is for attaching the screenshot to the test at test level with String path + title")
                .info("This is a info msg")
                .addScreenCaptureFromPath(path, "Google with String ");                     // best!!!!



        // when we are done with the reporting > need to use flush
        extentReports.flush();
        driver.close();
        // open the report after run ->  Automatically by java using - default browser
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());
    }


    @Test
    public static void screenShots_LogLevel() throws Exception{
        driver = new ChromeDriver();
        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";

        // setting up extent report engine + creating spark report instance
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
        extentReports.attachReporter(sparkReporter);
        driver.get("https://www.google.com/");


        /*
         LOG level screenShots
         */


        // using Base64
        String base54 = takeScreenShot();
        extentReports.createTest("ScreenShot Test 5", "Attaching screenshot at the Log level + Base64")
                .info("This is a Log level screen shot")
                .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base54, "Google page + Base65").build());


        // using String path
        String path = takeScreenShot("google.jpg");
        extentReports.createTest("Screenshot Test 6", "Attaching screenshot at Log level + String path")
                .info("This is a Log level screen shot")
                        .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google page + String path").build());




        // Log Exception + Base64

        Throwable throwable = new Throwable("This is a throwable exception");           // custom exception

        extentReports.createTest("ScreenShot Test 5", "Attaching screenshot at the Log level + Base64")
                .info("This is a Log level screen shot")
                .fail(throwable, MediaEntityBuilder.createScreenCaptureFromBase64String(base54, "Google page + Base65").build());



        //***** Log Exception + String path          -------> SO, THIS IS THE BEST > SINCE EXCEPTION & STRING PATH & ALL ARE IN LOG LEVEL, USE IT IN THE FRAMEWORK

        extentReports.createTest("Screenshot Test 6", "Attaching screenshot at Log level + String path")
                .info("This is a Log level screen shot")
                .fail(throwable, MediaEntityBuilder.createScreenCaptureFromPath(path, "Google page + String path").build());

        // I will use the above code to process the screenshot in my framework



        // when we are done with the reporting > need to use flush
        extentReports.flush();
        driver.close();
        // open the report after run ->  Automatically by java using - default browser
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());
    }



    /*
    Utility methods for String path & for Base64
     */


    public static String takeScreenShot(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/resources/screenShots/" + fileName);                        //new File("./ScreenShots/" + fileName);         - for project directory
        try {
            FileHandler.copy(sourceFile, destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");

        return destFile.getAbsoluteFile().toString();                                           // we need the destination path as we need to pass it to the report

    }


    public static String takeScreenShot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot successful");
        return base64Code;
    }
}
