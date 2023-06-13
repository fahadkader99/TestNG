package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
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

public class MultipleReports_All_Fail_9 {

    @Test
    public static void add_system_OrEnvironmentInfo_toReports() throws Exception{
        /*
        --> Generate multiple reports
        - 1 report with all the result
        - 1 report with all the fail test
         */

        String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Full_Test.html");                                        // Full test report

        ExtentSparkReporter sparkReporterFail = new ExtentSparkReporter("Failed_Test.html");                                 // Failed test report
        sparkReporterFail.filter().statusFilter().as(new Status[]{Status.FAIL}).apply();

        ExtentSparkReporter sparkReporterSkipAndWarning = new ExtentSparkReporter("Skip_Warning_Test.html");                  // Skip & Warning test report
        sparkReporterSkipAndWarning.filter().statusFilter().as(new Status[]{Status.SKIP, Status.WARNING}).apply();
        // also report configuration can be made separately for each reports but now the below changes will effect only to 1 report instance

        /* Configuration changes ----------> Beautification of the report */

        /* ------------- 1. Full test report config --------------------- */
        ExtentSparkReporterConfig config = sparkReporter.config();
        config.setTheme(Theme.DARK);                                                                                     // for theme
        config.setReportName("IAM & PAM Automation Report");                                                            // report Name
        config.setDocumentTitle("MRO All Test");
        config.setTimeStampFormat("dd-MM-yyyy hh:mm:ss");                                                             // Date format
        config.setCss(".badge-primary{background-color:#e63f65}");                                                   // changing the color of the Time
        config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");                            // to hide the logo from top left corner - extent logo
        /* ------------------ Updating extent report left TABS | show only what is needed ------------------------- */

        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{                                                // removing the Device tab only
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.AUTHOR
        }).apply();

        /* ------ 2 Failed_Test report config ---------- */
        sparkReporterFail.config().setTheme(Theme.DARK);
        sparkReporterFail.config().setReportName("Failed Test report");
        sparkReporterFail.config().setDocumentTitle("MRO_Failed_Test");
        sparkReporterFail.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        sparkReporterFail.config().setCss(".badge-primary{background-color:#e63f65}");
        sparkReporterFail.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");

        sparkReporterFail.viewConfigurer().viewOrder().as(new ViewName[]{                                                // removing the Device tab only
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.AUTHOR
        }).apply();

        /* --------- 3 Skip_Warning_Test report config -------------- */
        sparkReporterSkipAndWarning.config().setTheme(Theme.DARK);
        sparkReporterSkipAndWarning.config().setReportName("Skipped & Warning report");
        sparkReporterSkipAndWarning.config().setDocumentTitle("MRO Skip & Warning");
        sparkReporterSkipAndWarning.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        sparkReporterSkipAndWarning.config().setCss(".badge-primary{background-color:#e63f65}");
        sparkReporterSkipAndWarning.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");

        sparkReporterSkipAndWarning.viewConfigurer().viewOrder().as(new ViewName[]{                                                // removing the Device tab only
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.AUTHOR
        }).apply();


        /* ------------------- Adding System config info ---------------------- */

        // these settings can be applied for 3 Test as well just like we did above.
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("System", systemName());
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
        extentReports.setSystemInfo("Java", System.getProperty("java.version"));
        extentReports.setSystemInfo("Browser", getBrowserInfo());
        extentReports.setSystemInfo("Country", System.getProperty("user.country"));
        extentReports.setSystemInfo("App URL", "Get it from the Framework");
        extentReports.setSystemInfo("Application ", "IAM | PAM");
        extentReports.setSystemInfo("Environment", "Get the environment from Framework");

        /* ---------- attaching all the report instance to the main --------------- */
        extentReports.attachReporter(sparkReporter, sparkReporterFail, sparkReporterSkipAndWarning);

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

        // Test 3
        extentReports.createTest("Test 3", "Test with ^^ Additional Info")
                .assignAuthor("Sania_Jahan")
                .assignCategory("Smoke")
                .assignDevice(systemName())
                .skip("This is a skipped test");


        // Test 4
        extentReports.createTest("Test 4", "Test with ^^ Additional Info")
                .assignAuthor("Ayesha_Nahar")
                .assignCategory("Regression")
                .assignDevice(systemName(), "Chrome 101")
                .warning("This is a warning test");

        // Test 5 test with exception
        Throwable t = new RuntimeException("This is a custom exception");
        extentReports.createTest("Exception test", "Test with exception").fail(t);



        extentReports.flush();

        // Opening 3 reports
        Desktop.getDesktop().browse(new File("Full_Test.html").toURI());
        Desktop.getDesktop().browse(new File("Failed_Test.html").toURI());
        Desktop.getDesktop().browse(new File("Skip_Warning_Test.html").toURI());


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
