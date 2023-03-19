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
		option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Login']"));
		WebElement searchBtn= driver.findElement(By.xpath("//div[text()='Search']"));
		WebElement searchBox= driver.findElement(By.xpath("//input[@type='text' and @placeholder='Enter skills / designations / companies']"));
		//borderCreation(ele, driver);
		//flashing(ele, driver);		
		//generateAlert(driver, "Landed On Login Page");
		//driver.switchTo().alert().accept();
		/*
		  ele.click(); 
		  Thread.sleep(2000); 
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		 
		ele.click();
		Thread.sleep(2000);
		refreshPageJS(driver);*/
		
		/*System.out.println("Title by Driver -->"+driver.getTitle());
		getTitle(driver);
		System.out.println("URL by Driver -->"+driver.getCurrentUrl());
		getURL(driver);*/
		
		scrollToHeight(driver);
		Thread.sleep(2000);
		scrollToElement(driver, searchBox);
		Thread.sleep(2000);
		searchBox.sendKeys("Automation Testing");
		Thread.sleep(2000);
		scrollToElement(driver, searchBtn);
		Thread.sleep(2000);
		clickOnElement(searchBtn, driver);
		//searchBtn.click();
		
		
	}
	
	// 1. To DrawBorder around an Element
	public static void borderCreation(WebElement etr, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid red'", etr);
	}
	
	// 2. To Highlight an Element
	public static void flashing(WebElement etr, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String backGroundColor= etr.getCssValue("backgroundColor");
		System.out.println("BackGround Color of Element -->"+backGroundColor);
		
		for(int i=0;i<10;i++) {
			
			colorChange(etr, driver, "rgb(67,200,21)");
			colorChange(etr, driver, backGroundColor);
			
		}
	}
	
	public static void colorChange(WebElement etr, WebDriver driver,String color) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", etr);		
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
	public static void getTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Title of page in JS by To String-->" +
		js.executeScript("return document.title;").toString());
		String title = (String) js.executeScript("return document.title;");
		System.out.println("Title of page in JS by Type Casting-->" + title);
	}
	
	// 7. To retrieve the URL using JavaScript
	
	public static void getURL(WebDriver driver) {
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

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	//9. To Click on an Element by using JaveScript
	public static void clickOnElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
}
