package SeleniumTutorialsARC;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarsNonGeneric {
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
		driver.findElement(By.id("first_date_picker")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));

		/*
		 * driver.findElement(By.id("first_date_picker")).sendKeys("09/09/2023");
		 * driver.findElement(By.id("first_date_picker")).sendKeys(Keys.ENTER);
		 */
		selectDate("31", "December", "2024");
		//selectDate("19", "January", "2025");

	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static String[] getMonthYear(String monthYear) {
		return monthYear.split(" ");
	}

	public static void selectDate(String expDate, String expMonth, String expYear) {
		
		if (expMonth.equals("February") && Integer.parseInt(expDate) > 29) {
			System.out.println("Wrong date -->" + expMonth + ":" + expMonth);
			return;
		}
		if (Integer.parseInt(expDate) > 31) {
			System.out.println("Wrong date -->" + expMonth + ":" + expMonth);
			return;
		}

		String monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYear);

		while (!(getMonthYear(monthYear)[0].equals(expMonth) && 
				getMonthYear(monthYear)[1].equals(expYear))) {
			if (Integer.parseInt(expYear) > Integer.parseInt(getMonthYear(monthYear)[1])) {
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			} 
			else if (Integer.parseInt(expYear) <= Integer.parseInt(getMonthYear(monthYear)[1])){
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
			monthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(monthYear);

		}
		try {
			WebElement ele = driver.findElement(By.xpath("//a[text()='" + expDate + "']"));
			scrollToElement(driver, ele);
			ele.click();
		} catch (Exception e) {
			System.out.println("Wrong date -->" + expMonth + ":" + expMonth);
		}
	}
}
