package inClasstesting3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		Thread.sleep(3000);
		WebElement loginBtn= driver.findElement(By.id("login_Layer"));		
		//borderCreation(loginBtn, driver);
		//flashing(loginBtn, driver);
		//generateAlert(driver, "Test case Passed");
		//clickOnElement(loginBtn, driver);
		//Thread.sleep(3000);
		//WebElement username=driver.findElement(By.xpath("(//input[@class='suggestor-input '])[1]"));
		//enterValueInTextBox(username, driver, "arcautomation2023@gmail.com");
		//Thread.sleep(3000);
		//refreshPageJS(driver);
		
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getTitle());
		
		//getURL(driver);
		//getTitle(driver);
		/*WebElement viewAll=driver.findElement(By.linkText("View all companies"));
		Thread.sleep(3000);
		scrollToHeight(driver);
		Thread.sleep(3000);
		scrollToElement(driver, viewAll);
		Thread.sleep(3000);
		clickOnElement(viewAll, driver);*/
		/*clickOnElement(loginBtn, driver);
		WebElement UN = driver.findElement(By.xpath("//label[text()='Email ID / Username']//following-sibling::input"));
		enterValueInTextBox(UN, driver, "arcautomation2023@gmail.com");
		Thread.sleep(3000);
		retrieveValueOfElement(driver, UN);*/
		
		//hideElement(driver, loginBtn);
		//clickOnElement(loginBtn, driver);
		getElementInnerText(driver, loginBtn);
		modifyElement(driver, loginBtn, "Sign In");
		
	}
	
	
	public static void borderCreation(WebElement etr, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].style.border='5px solid blue'", etr);
		
		
	}
	public static void flashing(WebElement etr, WebDriver driver) throws InterruptedException {
		String backGroundColor= etr.getCssValue("backgroundColor");		
		System.out.println("BackGround Color of Element -->"+backGroundColor);
		for(int i=0;i<10;i++) {
			colorChange(etr, driver, "rgb(200,20,81)");
			colorChange(etr, driver, backGroundColor);
		}
	}
	
	public static void colorChange(WebElement etr, WebDriver driver,String color) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", etr);		
		Thread.sleep(1000);
	}


	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "');");
	}
	
	public static void clickOnElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void enterValueInTextBox(WebElement element, WebDriver driver, String UN) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + UN + "';", element);
	}
	public static void enterValueInTextBox(WebElement element, String UN) {
		element.sendKeys(UN);
	
	}
	public static void refreshPageJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	public static void getURL(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Title of page by one way-->" + js.executeScript("return document.URL;").toString());
		String title = (String) js.executeScript("return document.URL;");
		System.out.println("Title of page by other way-->" + title);
	}

	public static void getTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("URL of page by one way-->" + js.executeScript("return document.title;").toString());
		String title = (String) js.executeScript("return document.title;");
		System.out.println("URL of page by other way-->" + title);
	}
	
	public static void scrollToHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static String retrieveValueOfElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return arguments[0].value;", element);
		System.out.println("Value from Element-->" + value);
		return value;
	}
	
	public static void hideElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='none';", element);
	}
	
	public static void hideElement(WebDriver driver, List<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		for(WebElement ele:element) {
		js.executeScript("arguments[0].style.display='none';", ele);
		System.out.println("Mission Done");
		}
	}
	public static void modifyElement(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerText = '" + value + "';", element);
	}
	public static void getElementInnerText(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innerText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
		System.out.println("Inner Text of Element"+innerText);
	}
}
