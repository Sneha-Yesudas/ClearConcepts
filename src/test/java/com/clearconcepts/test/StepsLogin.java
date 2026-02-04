package com.clearconcepts.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsLogin {//button[@type="submit" and @data-qa="login-button"]

	public static void main(String[] args) {
		
	System.out.println("This is logintest");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://automationexercise.com/");
	driver.manage().window().maximize();
	
	By signUpLoginMenuLocator=By.xpath("//a[contains(text(),\"Signup\")]");
	WebElement signUpLoginMenuElement=   driver.findElement(signUpLoginMenuLocator);
	signUpLoginMenuElement.click();
	
	By loginEmailLocator=By.xpath("//div[@class=\"login-form\"]//input[@type=\"email\"]");
	WebElement loginEmailElement =driver.findElement(loginEmailLocator);
	loginEmailElement.sendKeys("jikoweb868@daikoa.com");
	
	By loginPasswordLocator=By.xpath("//input[@type=\"password\"]");
	WebElement loginPasswordElement =driver.findElement(loginPasswordLocator);
	loginPasswordElement.sendKeys("password");
	
	By loginButtonLocator=By.xpath("//button[@type=\"submit\" and @data-qa=\"login-button\"]");
	WebElement loginButtonElement =driver.findElement(loginButtonLocator);
	loginButtonElement.click();
	
	

	}

}
