package com.clearconcepts.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.clearconcepts.utilities.Browserutility;

public final class LoginPage extends Browserutility {

	private static final By LOGINEMAILLOCATOR = By.xpath("//div[@class=\"login-form\"]//input[@type=\"email\"]");
	private static final By LOGINPASSWORDLOCATOR = By.xpath("//input[@type=\"password\"]");
	private static final By LOGINBUTTONLOCATOR = By.xpath("//button[@type=\"submit\" and @data-qa=\"login-button\"]");
	private static final By LOGINUNSUCCESFULLLOCATOR = By.xpath("//p[text()=\"Your email or password is incorrect!\"]");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public Dashboardpage doLogin(String email,String password) {
		sendText(LOGINEMAILLOCATOR, email);
		sendText(LOGINPASSWORDLOCATOR, password);
		click(LOGINBUTTONLOCATOR);
		Dashboardpage dashboardPage=new Dashboardpage(getDriver());
		return dashboardPage;
	}
	
	
	public String verifyLoginwithWrongCredentials(String email,String password) {
		sendText(LOGINEMAILLOCATOR, email);
		sendText(LOGINPASSWORDLOCATOR, password);
		click(LOGINBUTTONLOCATOR);
		return getText(LOGINUNSUCCESFULLLOCATOR);
	}

}
