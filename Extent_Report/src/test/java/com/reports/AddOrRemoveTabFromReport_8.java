package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.net.InetAddress;

public class AddOrRemoveTabFromReport_8 {

    @Test
    public static void add_system_OrEnvironmentInfo_toReports() throws Exception{
        /*
        >> Add details to the reports:
        - OS
        - Ram
        - Rom
        - Browser
        - URL
        - Env

        >> Update left side tabs on the report
         */

        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory

        /* Configuration changes ----------> Beautification of the report */

        ExtentSparkReporterConfig config = sparkReporter.config();
        config.setTheme(Theme.DARK);                                                                              // for theme
        config.setReportName("IAM & PAM Automation Report");                                                        // report Name
        config.setDocumentTitle("MRO");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");                                                             // Date format
        config.setCss(".badge-primary{background-color:#e63f65}");                                                  // changing the color of the Time
        config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");                            // to hide the logo from top left corner - extent logo

        /* ------------------ Updating extent report left TABS | show only what is needed ------------------------- */

        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{                                                // removing the Device tab only
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.AUTHOR
        }).apply();


        /* ------------------- Adding System config info ---------------------- */

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("System", systemName());
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
        extentReports.setSystemInfo("Java", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", getBrowserInfo());
        extentReports.setSystemInfo("Country", System.getProperty("user.country"));
        extentReports.setSystemInfo("App URL", "Get it from the Framework");
        extentReports.setSystemInfo("Application ", "IAM | PAM");
        extentReports.setSystemInfo("Environment", "Get the environment from Framework");


        /* ------------------------- */
        extentReports.attachReporter(sparkReporter);                              // add all the report reference variable here

        /* ----------------------- Report setup ends ---------------------- */


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

        // 5 test with exception
        Throwable t = new RuntimeException("This is a custom exception");
        extentReports.createTest("Exception test", "Test with exception").fail(t);



        extentReports.flush();
        Desktop.getDesktop().browse(new File("testReport1.html").toURI());


    }


    public static String getBrowserInfo(){
        String browser = "";
        String browserVersion = "";
        String fullBrowser = "";
        WebDriver driver = new ChromeDriver();
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        browser = capabilities.getBrowserName();
        browserVersion = capabilities.getBrowserVersion();
        fullBrowser = browser +" "+ browserVersion;
        //System.out.println("\nBrowser: "+browser +"\nVersion: " + browserVersion);
        driver.quit();

        return fullBrowser;

    }

    public static String systemName(){
        String systemName = "";
        try{
            systemName = InetAddress.getLocalHost().getHostName();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("System: " + systemName);
        return systemName;
    }

    public static void getAdditionalInfo(){
        String osName =  System.getProperty("os.name");
        System.out.println("OS name: " + osName);

        String country = System.getProperty("user.country");
        System.out.println("Country: " + country);

        String javaVersion = System.getProperty("java.version");
        System.out.println("Java version: " + javaVersion);

        String userName = System.getProperty("user.name");
        System.out.println("User: " + userName);

    }


}
