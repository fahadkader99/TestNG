package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.net.InetAddress;

public class ReportConfigChanges_6 {
    /*

    - change the theme - light / dark
    - change the report name
    - change the document title
    - change Date & Time stamp format
    - Apply the CSS
    - run the JS

     */

    @Test
    public static void make_Changes_1() throws Exception{
        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory

        /*
        Configuration changes ----------> Beautification of the report
         */
        ExtentSparkReporterConfig config = sparkReporter.config();
        config.setTheme(Theme.DARK);                                                                              // for theme
        config.setReportName("IAM & PAM Automation Report");                                                        // report Name
        config.setDocumentTitle("MRO");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");                                                             // Date format
        config.setCss(".badge-primary{background-color:#e63f65}");                                                  // changing the color of the Time
        config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");                            // to hide the logo from top left corner - extent logo
        /* ------------------- */
        extentReports.attachReporter(sparkReporter);




        // Test 1
        extentReports.createTest("Test 1", "Test with ^^ Additional Info")
                .assignAuthor("Fahad_Kader")
                .assignCategory("Regression")
                .assignDevice(systemName())
                .pass("This is a passed test");


        // Test 2
        extentReports.createTest("Test 2", "Test with ^^ Additional Info")
                .assignAuthor("Esrat_Jahan")
                .assignCategory("Smoke")
                .assignDevice(systemName())
                .fail("This is a failed test");



        extentReports.flush();
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());


    }


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
