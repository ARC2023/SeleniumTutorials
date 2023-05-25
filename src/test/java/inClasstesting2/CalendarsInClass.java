package inClasstesting2;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumTutorialsARC.JavaScriptExecutorMethods;

public class CalendarsInClass {
	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement inputBox = driver.findElement(By.id("first_date_picker"));
		/*
		 * WebElement inputBox2= driver.findElement(By.id("second_date_picker"));
		 * inputBox.sendKeys("10/22/2023"); inputBox.sendKeys(Keys.ENTER);
		 * dateByJS(driver, "06/12/2023", inputBox2); inputBox2.sendKeys(Keys.ENTER);
		 * 
		 * inputBox.click(); WebElement MonthYearElement =
		 * driver.findElement(By.className("ui-datepicker-title")); String MonthYear =
		 * MonthYearElement.getText(); System.out.println("Calendar Value-->" +
		 * MonthYear); String[] MonthYearArray = MonthYear.split(" "); String Month =
		 * MonthYearArray[0].trim(); String Year = MonthYearArray[1].trim();
		 * 
		 * while (!(Month.equals("March") && Year.equals("2024"))) {
		 * driver.findElement(By.xpath("//span[text()='Next']")).click();
		 * MonthYearElement = driver.findElement(By.className("ui-datepicker-title"));
		 * MonthYear = MonthYearElement.getText();
		 * System.out.println("Calendar Value-->" + MonthYear); MonthYearArray =
		 * MonthYear.split(" "); Month = MonthYearArray[0].trim(); Year =
		 * MonthYearArray[1].trim(); }
		 * driver.findElement(By.xpath("//a[text()='12']")).click();
		 */

		selectDate("25", "April", "2025");
	}

	public static void selectDate(String date, String month, String year) {

		if (month.equals("February") && Integer.parseInt(date) > 29) {

			System.out.println("Wrong Date Your are idiot :--> " + date + " " + month + " " + year);
			return;
		}
		if (Integer.parseInt(date) > 31) {

			System.out.println("Wrong Date Your are idiot :--> " + date + " " + month + " " + year);
			return;
		}

		WebElement inputBox = driver.findElement(By.id("first_date_picker"));
		inputBox.click();
		WebElement MonthYearElement = driver.findElement(By.className("ui-datepicker-title"));
		String MonthYear = MonthYearElement.getText();
		System.out.println("Calendar Value-->" + MonthYear);
		while (!(splitter(MonthYear)[0].trim().equals(month) && splitter(MonthYear)[1].trim().equals(year))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			MonthYearElement = driver.findElement(By.className("ui-datepicker-title"));
			MonthYear = MonthYearElement.getText();
			System.out.println("Calendar Value-->" + MonthYear);
		}
		try {
		WebElement dateClicker = driver.findElement(By.xpath("//a[text()='" + date + "']"));
		JavaScriptExecutorMethods.scrollToElement(driver, dateClicker);
		dateClicker.click();
		}catch(Exception e) {
			System.out.println("Wrong Date Your are idiot :--> " + date + " " + month + " " + year);
		}
	}

	public static String[] splitter(String str) {
		String[] splitter = str.split(" ");
		return splitter;
	}

	public static void dateByJS(WebDriver driver, String date, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
	}

}
