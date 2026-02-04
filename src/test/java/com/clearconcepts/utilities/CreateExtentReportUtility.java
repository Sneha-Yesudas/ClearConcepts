package com.clearconcepts.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateExtentReportUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public static void createExtentReport() {
		
		ExtentSparkReporter   extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createExtentTest(String nameOfTest) {
		ExtentTest test=extentReports.createTest(nameOfTest);
		extentTest.set(test);
		
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	
	public static void writeReport() {
		extentReports.flush();
	}

}
