package SeleniumTutorialsARC;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptExecutorMethods {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Login']"));
		getElementInnerText(driver, ele);
		flashing(ele, driver);
		
		
		
		/*
		hideElement(driver, ele);
		modifyElement(driver, ele, "SignUp");
		borderCreation(ele, driver);
		Thread.sleep(3000);
		scrollToHeight(driver);
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//div[text()='Search']"));
		scrollToElement(driver, search);
		Thread.sleep(3000);
		clickOnElement(search, driver);
		Thread.sleep(3000);
		WebElement UN = driver.findElement(By.xpath("//label[text()='Email ID / Username']//following-sibling::input"));
		clickOnElement(ele, driver);
		enterValueInTextBox(UN, driver, "arcautomation2023@gmail.com");
		Thread.sleep(3000);
		retrieveValueOfElement(driver, UN);
		Thread.sleep(3000);
		generateAlert(driver, "Defect Defect Defect");
		driver.switchTo().alert().accept();
		refreshPageJS(driver);
		getTitle(driver);
		getURL(driver);
		retriveInnerTextOfPage(driver);*/

	}
	
	public static void flashing(WebElement etr, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String backGroundColor= etr.getCssValue("backgroundColor");
		System.out.println("BackGround Color of Element -->"+backGroundColor);
		for(int i=0;i<10;i++) {
			colorChange(etr, driver, "rgb(0,200,21)");
			colorChange(etr, driver, backGroundColor);
		}
	}
	
	public static void colorChange(WebElement etr, WebDriver driver,String color) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", etr);		
		Thread.sleep(1000);
	}

	
	
	public static void borderCreation(WebElement etr, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='10px solid red'", etr);
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

	public static void retriveInnerTextOfPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Inner Text of page by one way-->"
				+ js.executeScript("return document.documentElement.innerText;").toString());
		String title = (String) js.executeScript("return document.documentElement.innerText;");
		System.out.println("Inner Text of page by other way-->" + title);
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

	public static void closeAlert(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.close();");
	}

	public static void hideElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='none';", element);
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
	public static void waitForAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var callback = arguments[arguments.length - 1];" + "var interval = setInterval(function() {"
				+ "if (arguments[0].offsetHeight > 0) {" + "clearInterval(interval);" + "callback();" + "}"
				+ "}, 100);", element);
	}
	

}
