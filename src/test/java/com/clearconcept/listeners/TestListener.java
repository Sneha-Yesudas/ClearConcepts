package com.clearconcept.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.clearconcepts.test.TestBase;
import com.clearconcepts.utilities.Browserutility;
import com.clearconcepts.utilities.CreateExtentReportUtility;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		/*
		 * extentSpark=new
		 * ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
		 * extentreports=new ExtentReports() ;
		 * extentreports.attachReporter(extentSpark);
		 */

		CreateExtentReportUtility.createExtentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		CreateExtentReportUtility.writeReport();
	}

	@Override
	public void onTestStart(ITestResult result) {

		// extentTest=extentreports.createTest(result.getMethod().getDescription());
		CreateExtentReportUtility.createExtentTest(result.getMethod().getDescription());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		CreateExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName());
		CreateExtentReportUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());
	    Object testclass=result.getInstance();
	    
	     Browserutility browserutility=((TestBase)testclass).getInstance();
	     String path=browserutility.takeScreenshot();
	     CreateExtentReportUtility.getExtentTest().addScreenCaptureFromPath(path);
	     
	    
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		CreateExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		CreateExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName());
	}

}
