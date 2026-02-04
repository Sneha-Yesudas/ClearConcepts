package com.clearconcepts.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.clearconcepts.constans.Browser;
import com.clearconcepts.pom.HomePage;
import com.clearconcepts.utilities.Browserutility;
import com.clearconcepts.utilities.LambdaUtility;

public class TestBase {

	HomePage homepage;

	boolean isLambda;
	WebDriver lambdadriver;

	@Parameters({ "browserName", "isHeadless", "isLambda" })
	@BeforeMethod
	public void setup(@Optional("chrome") String browserName,
			@Optional("true") boolean isHeadless, 
			@Optional("false")boolean isLambda, ITestResult result) {
		this.isLambda = isLambda;
		if (isLambda) {
			lambdadriver = LambdaUtility.CloudTestUtility(browserName, result.getMethod().getMethodName());
			homepage = new HomePage(lambdadriver);
		} else {
			homepage = new HomePage(Browser.valueOf(browserName.toUpperCase()), isHeadless);
		}
	}

	@AfterMethod
	public void closedriver() {
		if (isLambda) {
			LambdaUtility.quitsession();
		}
	}

	public Browserutility getInstance() {
		return homepage;
	}

}
