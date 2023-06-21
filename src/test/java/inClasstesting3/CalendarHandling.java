package inClasstesting3;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarHandling {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.findElement(By.id("first_date_picker")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		selectDate("31", "December", "2030");
		
	}

	public static void selectDate(String date,String month,String year) throws Exception {
		
		if(Integer.parseInt(date)>31) {
			throw new Exception("Wrong Date");
		}
		if(month.equals("February") && Integer.parseInt(date)>29) {
			throw new Exception("For February the date is incorrect");
		}
		
		
		String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println("Month and Year from Calendar UI-->"+monthyear);		
		String[] spliiter=monthyear.split(" ");
		System.out.println("Month from Calendar UI-->"+spliiter[0]);
		System.out.println("Year from Calendar UI-->"+spliiter[1]);
		
		int currentYear=Integer.parseInt(spliiter[1]);
		
		while( !(spliiter[0].equals(month) &&  spliiter[1].equals(year) ) ) {
								// Dec     2023
								// Jan    2024
			// 					2024 > 2023
			if(Integer.parseInt(year)>currentYear) {					
				
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				
				
			} else if(Integer.parseInt(year)<=Integer.parseInt(spliiter[1])) {				 
						
				driver.findElement(By.xpath("//span[text()='Prev']")).click();

			}					
			monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println("Month and Year from Calendar UI-->"+monthyear);
			spliiter=monthyear.split(" ");
			System.out.println("Month from Calendar UI-->"+spliiter[0]);
			System.out.println("Year from Calendar UI-->"+spliiter[1]);			
			
		}
		try {
			
			WebElement ele=driver.findElement(By.xpath("//a[text()='"+date+"']"));
			new Actions(driver).scrollToElement(ele);
			JavaScriptExecutor.clickOnElement(ele, driver);
			
		}catch(Exception e) {
			
			
		}

		
		
		
		
		
	}
	
	
	
	
	
}
