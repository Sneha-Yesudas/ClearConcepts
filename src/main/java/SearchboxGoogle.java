import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchboxGoogle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By searchTextboxLocator = By.xpath("//*[@title=\"Search\"]");
		By searchElementsLocator = By.xpath("//ul[@role=\"listbox\"]//li");

		WebElement searchTextboxElement = driver.findElement(searchTextboxLocator);

		searchTextboxElement.sendKeys("selenium");
		Thread.sleep(1000);

		List<WebElement> searchElements = driver.findElements(searchElementsLocator);
		System.out.println(searchElements.get(4).getText());
		
		WebElement listItem=searchElements.get(4);
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(listItem));

		for (WebElement searchElement : searchElements) {

			System.out.println(searchElement.getText());
		}

//		for (WebElement searchElement:      searchElements) {
//			
//			System.out.println(searchElement.getText());
//		}

	}

}
