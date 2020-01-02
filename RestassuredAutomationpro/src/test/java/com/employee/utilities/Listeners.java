package com.employee.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {
	
	public ExtentHtmlReporter extenthtmlreport;
	public ExtentReports extentreport;
	public ExtentTest extenttest;
	

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extentreport.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		extenthtmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReportnew.html");
		extenthtmlreport.config().setDocumentTitle("Automation Report new");
		extenthtmlreport.config().setReportName("Restassured report new");
		extenthtmlreport.config().setTheme(Theme.DARK);
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(extenthtmlreport);
		extentreport.setSystemInfo("Host name", "localhost");
		extentreport.setSystemInfo("Environment", "QA");
		extentreport.setSystemInfo("username", "allwin");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest=extentreport.createTest(result.getName());
		System.out.println("The failed test is : "+result.getName());
		extenttest.log(Status.FAIL,"The test case passed is:"+result.getName());

	}	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest=extentreport.createTest(result.getName());
		System.out.println("The passed test is : "+result.getName());
		extenttest.log(Status.PASS,"The test case passed is:"+result.getName());

	}

}
