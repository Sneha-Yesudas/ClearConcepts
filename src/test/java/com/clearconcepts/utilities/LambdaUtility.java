package com.clearconcepts.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaUtility {

	public static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> desiredLocal=new ThreadLocal<DesiredCapabilities>();

	public static WebDriver CloudTestUtility(String browsername, String testname) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browsername);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("user", "snehamary575");
		ltOptions.put("accessKey", "LT_0wyK2Yun8crQYJcvxTHUovfKVv1KrISz62BZ1PVaFvBcXZK");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testname);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		desiredLocal.set(capabilities);

		WebDriver driver = null;
		try {
			driver = (new RemoteWebDriver(new URL(HUBURL), desiredLocal.get()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverlocal.set(driver);

		return driverlocal.get();

	}
	
	public static void quitsession() {
		if(driverlocal.get()!=null) {
			driverlocal.get().quit();
		}
	}

}
