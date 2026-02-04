package com.clearconcepts.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.clearconcepts.utilities.Browserutility;

public final class Dashboardpage extends Browserutility {

	private static final By VERIFYLOOGEDINLOCATOR = By.xpath("//a[contains(text(),\"Logout\")]");

	public Dashboardpage(WebDriver driver) {
		super(driver);

	}

	public String verifyLogin() {

		return getText(VERIFYLOOGEDINLOCATOR);

	}

}
