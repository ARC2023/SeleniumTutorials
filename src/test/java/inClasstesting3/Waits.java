package inClasstesting3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		// 1. Visibility
		//Locators
		By io=By.id("id");
		//WebElement
		WebElement ele = driver.findElement(io);
		List<WebElement> List = driver.findElements(io);
		
		// locator is used to create a webelement using webdriver 
		
		//a.An expectation for checking that an element, known to be present on the DOM of a page, is visible. Visibility means that the element is not only displayed but also has a height andwidth that is greater than 0.
		// For Single Element
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.visibilityOfElementLocated(io));
		
		// For list of WebElement
		wait.until(ExpectedConditions.visibilityOfAllElements(List));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(io));
		
		// For Nested Elements
		WebElement yu=driver.findElement(By.id("livePreTable"));
		By ChildLocator=By.xpath("//td//a");
		By ParentLocator=By.xpath("//table[@id='livePreTable']");
		System.out.println(wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
				ParentLocator,ChildLocator )).size());
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
				yu,ChildLocator)).size());
		
		
		
		//2. Invisibility
		System.out.println(wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("login_Layer")))));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfAllElements(
				driver.findElements(By.xpath("//div[@class='ntc__chips-row']")))));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login_Layer"))));		
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login_Layer"),"Login")));
		

		
		
	}

}
