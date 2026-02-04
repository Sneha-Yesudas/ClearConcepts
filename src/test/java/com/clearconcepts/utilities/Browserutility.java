package com.clearconcepts.utilities;

import java.awt.Checkbox;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.clearconcepts.constans.Browser;

public abstract class Browserutility {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public Browserutility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public Browserutility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {

			driver.set(new FirefoxDriver());
		}

		else if (browserName.equalsIgnoreCase("Edge")) {

			driver.set(new EdgeDriver());
		}

		else if (browserName.equalsIgnoreCase("Safari")) {

			driver.set(new SafariDriver());
		}

		else {
			System.err.println("Give valid browsername");
		}
	}

	public Browserutility(Browser browserName,boolean headless) {

		if (browserName == Browser.CHROME) {
			if(headless) {
				ChromeOptions chromeoptions=new ChromeOptions();
				chromeoptions.addArguments("--headless");
				chromeoptions.addArguments("--disable-gpu");
				driver.set(new ChromeDriver(chromeoptions));
				
			}
			else {
			driver.set(new ChromeDriver());
			}
		}

		else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());

		}

		else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());

		} else {

			System.err.println("Input proper value");
		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void navigatetoUrl(String url) {

		driver.get().get(url);

	}

	public void maximizeWindow() {

		driver.get().manage().window().maximize();

	}

	public void closeWindow() {
		driver.get().quit();
	}

	public void click(By locator) {

		WebElement element = driver.get().findElement(locator);
		element.click();

	}

	public void sendText(By locator, String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);

	}

	public String getText(By locator) {

		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public String takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String dateformatter = LocalDateTime.now().format(datetime);

		String path = System.getProperty("user.dir") + "//screenshot//screenshot//" + dateformatter + "//.png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
