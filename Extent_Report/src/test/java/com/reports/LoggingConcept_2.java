package com.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoggingConcept_2 {
public static void main(String[] args) throws IOException {
	String reportPath1 = "/Users/fahadkader/Desktop/Git/TestNG/Extent_Report/testReport1.html";
	
	ExtentReports extentReports = new ExtentReports();
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReport1.html");			// relative path with the string & if only report name > will create the report on the project directory
	extentReports.attachReporter(sparkReporter); 												// attaching spark reporter to the Extent reporter engine.
	
	
	
	
	
	// always add test under extendReport object - Pass | Fail | SKIP
//	ExtentTest t1 = extentReports.createTest("test 1"); 								// by default test is always pass
//	t1.pass("This is passed ");

	
	// Method chaining process for better loggin
	
	extentReports.createTest("Test passed")
	.log(Status.INFO, "infor 1")
	.log(Status.INFO, "infor 1")
	.log(Status.PASS, "Pass 1")
	.log(Status.SKIP, "Skip 1")
	.log(Status.WARNING, "Warning 1")
	.log(Status.WARNING, "Warning 1")
	.log(Status.FAIL, "Fail 1")	
	.log(Status.FAIL, "Fail 1");
	
	// use the log events that are appropriately don't add all the log together in a method chaining. 
	
	
	
	
	
	
	
	
	
	// when we are done with the reporting > need to use flush
	extentReports.flush();
	
	
	// open the report after run ->  Automatically by java using - default browser
	Desktop.getDesktop().browse(new File("testReport1.html").toURI());
}
}
