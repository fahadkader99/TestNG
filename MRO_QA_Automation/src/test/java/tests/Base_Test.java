package test.java.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test.java.pages.EditCompliancePage;
import test.java.pages.EventPage;
import test.java.pages.HomePage;
import test.java.pages.LoginPage;
import test.java.utils.Property_Reader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public abstract class Base_Test {

    public static WebDriver driver;
    // Extent report properties
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    LoginPage loginPage;
    HomePage homePage;
    EventPage eventPage;
    EditCompliancePage editCompliancePage;


    @BeforeSuite
    public void beforeTestMethod() {
        // extent report files
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports" +File.separator+ "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("MRO Automation Report");
        htmlReporter.config().setReportName("Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester:", "Ashikul Fahad");

    }


    @BeforeMethod
    @Parameters(value = {"browser"})
    public void startUp(String browser, Method testMethod) {

        // creating a testMethod: it will pick up whichever method is getting executed & will create a test according to the method name. Using it to get the name of the test to use it for the report
        //logger = extent.createTest(testMethod.getName());

        setDriver(browser);
        //driver.manage().window().maximize();
        driver.get(Property_Reader.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Object for each Page
        loginPage = new LoginPage();
        homePage = new HomePage();
        eventPage = new EventPage();
        editCompliancePage = new EditCompliancePage();



    }


    @AfterMethod
    public void closeUp(ITestResult result) {        // getting the results using ITestResult, testNG function
        // additional values adding to our reports

        if (result.getStatus() == ITestResult.SUCCESS) {

            logger.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));

        }
        else if (result.getStatus() == ITestResult.FAILURE) {

            logger.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
            logger.fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP){

            logger.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.YELLOW));
            logger.skip(result.getThrowable());
        }


        // closing the driver
        driver.quit();

    }


    @AfterSuite
    public void afterTestMethod() {

        // just flushing all the reports
        extent.flush();
    }


    public void setDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {

            // execute chrome
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // execute firefox driver and so on.
            System.out.println("Firefox not required as per the requirements");
        }

    }


}
