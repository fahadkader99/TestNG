package com.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateBasicReport_1 {


	public static void main(String[] args) throws IOException {
		String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
		extentReports.attachReporter(sparkReporter); 												// attaching spark reporter to the Extent reporter engine.
		
		
		
		
		
		// always add test under extendReport object - Pass | Fail | SKIP
		ExtentTest t1 = extentReports.createTest("test 1"); 								// by default test is always pass
		t1.pass("This is passed ");
		
		ExtentTest t2 = extentReports.createTest("test 2"); 								// by default test is always pass
		t2.log(Status.FAIL, "Failed test");
		
		// this is simplified	- instead of putting into ref variable
		extentReports.createTest("Test 3").skip("This is skipped");
		
		
		
		
		
		
		
		
		
		
		// when we are done with the reporting > need to use flush
		extentReports.flush();
		
		
		// open the report after run ->  Automatically by java using - default browser
		Desktop.getDesktop().browse(new File("testReport1.html").toURI());
		
		
		 
	
	}
}
