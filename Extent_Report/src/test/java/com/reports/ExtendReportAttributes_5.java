package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class ExtendReportAttributes_5 {
    /*
    Attributes are the addition info that are provided to the test:
    Additional INFO to Pass:::
        - Author        - Dev                                                   - .AssignAuthor()
        - Category      - Groups in TestNG & Tag in cucumber  (Reg / Smoke)     - .assignCatagory()
        - Device        - Server / Local / Browser version                      - .assignDevice()

         // order don't matter
     */

    @Test
    public static void test() throws IOException {

        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
        extentReports.attachReporter(sparkReporter);
//        extentReports.createTest("Test NAME", "Test Description | OPTIONAL")
//                .info("ANY addition info");


        // 1
        extentReports.createTest("Test 1", "Test with ^^ Additional Info")
                .assignAuthor("Fahad_Kader")
                        .assignCategory("Regression")
                                .assignDevice(systemName())
                                        .pass("This is a passed test");


        // 2
        extentReports.createTest("Test 2", "Test with ^^ Additional Info")
                .assignAuthor("Esrat_Jahan")
                .assignCategory("Smoke")
                .assignDevice(systemName())
                .fail("This is a failed test");

        // 3
        extentReports.createTest("Test 3", "Test with ^^ Additional Info")
                .assignAuthor("Sania_Jahan")
                .assignCategory("Smoke")
                .assignDevice(systemName())
                .fail("This is a failed test");


        // 4
        extentReports.createTest("Test 4", "Test with ^^ Additional Info")
                .assignAuthor("Ayesha_Nahar")
                .assignCategory("Regression")
                .assignDevice(systemName(), "Chrome 101")
                .pass("This is a passed test");

        // 5
        extentReports.createTest("Test 5", "Test with ^^ Additional Info")
                .assignAuthor("Ahad_Kader")
                .assignCategory(new String[]{"Regression", "Smoke", "Sanity"})      // can pass an Array of string, lets say 1 script is part of many category
                .assignDevice(systemName(), "Safari 101")
                .pass("This is a passed test");


        // can  make a re-useable method so that we can call that multiple times



        extentReports.flush();
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());

    }

    /*
    static void testWithInfo(String testName, String testDescription, String author, String category, String device, String passFailDescription){
        extentReports.createTest(testName, testDescription)
                .assignAuthor(author)
                .assignCategory(category)
                .assignDevice(systemName(), device)
                .pass(passFailDescription);
    }
    */

    static String systemName(){
        String systemName = "";
        try{
            systemName = InetAddress.getLocalHost().getHostName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return systemName;
    }

}
