package com.clearconcepts.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.clearconcepts.constans.Browser.*;
import com.clearconcepts.pojo.User;
import com.clearconcepts.pom.HomePage;

@Listeners({ com.clearconcept.listeners.TestListener.class })
public class Logintest extends TestBase {

	@Test(description = "This is test to Verify login with correct data", dataProvider = "dataproviderformexcel", groups = {
			"regression", "smoke" }, dataProviderClass = com.clearconcepts.dataprovider.Dataprovider.class)
	public void verifyLogin(User user) {
		System.out.println("Inside test");
		System.out.println(user.getUsername().toString());
		assertEquals(homepage.clickSignupLoginMenu().doLogin(user.getUsername(), user.getPaswword()).verifyLogin(),
				"Logout");
	}

//	@Test(description = "This is test to Verify login with incorrect data", dataProvider = "dataproviderformexcel", groups = {
//			"regression", "smoke" }, dataProviderClass = com.clearconcepts.dataprovider.Dataprovider.class)
//	public void verifyLoginwithInvalid(User user) {
//		System.out.println("Inside test");
//		System.out.println(user.getUsername().toString());
//		assertEquals(homepage.clickSignupLoginMenu().verifyLoginwithWrongCredentials(user.getUsername(), user.getPaswword()),
//				"Your email or password is incorrect!");
//		
//	}

	@Test(description = "Check parallel mode for method")
	public void test() {
		assertEquals("true", "true");
	}

	@Test(description = "Check parallel mode for methods second")
	public void testparallel() {
		assertEquals("true", "true");
	}

}
