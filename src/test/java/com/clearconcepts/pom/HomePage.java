package com.clearconcepts.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.clearconcepts.constans.Browser;
import static com.clearconcepts.constans.Env.*;
import com.clearconcepts.utilities.Browserutility;
import com.clearconcepts.utilities.PropertiesUtility;

public final class HomePage extends Browserutility {

	public HomePage(Browser  browsername,boolean headless){

		super(browsername,headless);
		navigatetoUrl(PropertiesUtility.readPropertyFile(QA, "URL"));
		maximizeWindow();

	}

	public HomePage(WebDriver lambdadriver) {
		super(lambdadriver);
	}

	private static final By SIGNUPMENULOGINLOCATOR = By.xpath("//a[contains(text(),\"Signup\")]");

	public LoginPage clickSignupLoginMenu() {

		click(SIGNUPMENULOGINLOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}

}
