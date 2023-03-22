package inClass;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JSHandling {

	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		//option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Login']"));
		WebElement searchBtn = driver.findElement(By.xpath("//div[text()='Search']"));
		WebElement searchBox = driver.findElement(
				By.xpath("//input[@type='text' and @placeholder='Enter skills / designations / companies']"));
		// borderCreation(ele, driver);
		// flashing(ele, driver);
		// generateAlert(driver, "Landed On Login Page");
		// driver.switchTo().alert().accept();

		/*ele.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);

		ele.click();
		Thread.sleep(2000);
		refreshPageJS(driver);
*/
		/*
		  System.out.println("Title by Driver -->"+driver.getTitle());
		  getTitleJS(driver);
		  System.out.println("URL by Driver -->"+driver.getCurrentUrl());
		  getURLJS(driver);
		 

		
		  scrollToHeight(driver); 
		  Thread.sleep(2000); 
		  scrollInToElement(driver, searchBox); 
		  Thread.sleep(2000); 
		  searchBox.sendKeys("Automation Testing");
		  Thread.sleep(2000); 
		  scrollInToElement(driver, searchBtn); 
		  Thread.sleep(2000);
		  //searchBtn.click();
		  clickOnElement(searchBtn, driver);
		 
		  retriveInnerTextOfPage(driver);
		  
		
		clickOnElement(ele, driver);
		Thread.sleep(2000);
		WebElement UN = driver.findElement(By.xpath("//label[text()='Email ID / Username']//following-sibling::input"));
		UN.sendKeys("Sample@gmail.com");
		Thread.sleep(2000);
		enterValueInTextBox(UN, driver, "arcautomation2023@gmail.com");		
		retrieveValueOfElement(driver, UN);
		modifyElement(driver, ele, "Piyush");		
		hideElement(driver, ele);*/
		getElementInnerText(driver, ele);
		

	}

	// 1. To DrawBorder around an Element
	public static void borderCreation(WebElement etr, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid red'", etr);
	}

	// 2. To Highlight an Element
	public static void flashing(WebElement etr, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String backGroundColor = etr.getCssValue("backgroundColor");
		System.out.println("BackGround Color of Element -->" + backGroundColor);

		for (int i = 0; i < 10; i++) {

			colorChange(etr, driver, "rgb(67,200,21)");
			colorChange(etr, driver, backGroundColor);

		}
	}

	public static void colorChange(WebElement etr, WebDriver driver, String color) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", etr);
		Thread.sleep(500);
	}

	// 3. To Generate custom Alert during Test Execution

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "');");
	}

	// 4. To close a pop-up using JavaScript
	public static void closeAlert(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.close();");
	}

	// 5. To Refresh browser by using JavaScript

	public static void refreshPageJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	// 6. To Get Title by using JavaScript
	public static void getTitleJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out
				.println("Title of page in JS by To String-->" + js.executeScript("return document.title;").toString());
		String title = (String) js.executeScript("return document.title;");
		System.out.println("Title of page in JS by Type Casting-->" + title);
	}

	// 7. To retrieve the URL using JavaScript

	public static void getURLJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("URL of page in JS by To String-->" + js.executeScript("return document.URL;").toString());
		String URL = (String) js.executeScript("return document.URL;");
		System.out.println("URL of page in JS by Type Casting-->" + URL);
	}

	// 8. To Scroll Into View and Scroll Page Down

	public static void scrollToHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollInToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// 9. To Click on an Element by using JaveScript
	public static void clickOnElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// 10. To Get InnerText of page by using JavaScript
	
	public static void retriveInnerTextOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Inner Text of page by one way-->"
				+ js.executeScript("return document.documentElement.innerText;").toString());
		String title = (String) js.executeScript("return document.documentElement.innerText;");
		System.out.println("Inner Text of page by other way-->" + title);
	}
	// 11. To enter a value into a field
	
	public static void enterValueInTextBox(WebElement element, WebDriver driver, String UN) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + UN + "';", element);
	}
	
	// 12. To retrieve the value of an element using JavaScript
	public static String retrieveValueOfElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) 
				js.executeScript("return arguments[0].value;", element);
		System.out.println("Value from Element-->" + value);
		return value;
	}
	// 13. To change the text of an element using JavaScript
	public static void modifyElement(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerText = '" + value + "';", element);
	}
	
	// 14. To hide an element using JavaScript
	
	public static void hideElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='none';", element);
	}
	// 15. To wait for an element to become visible on the web page
	public static void waitForAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var callback = arguments[arguments.length - 1];" + "var interval = setInterval(function() {"
				+ "if (arguments[0].offsetHeight > 0) {" + "clearInterval(interval);" + "callback();" + "}"
				+ "}, 100);", element);
	}
	
	// 16. To retrieve the inner text of an element using JavaScript
	public static void getElementInnerText(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innerText = (String) 
				((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
		System.out.println("Inner Text of Element-->"+innerText);
	}
}
