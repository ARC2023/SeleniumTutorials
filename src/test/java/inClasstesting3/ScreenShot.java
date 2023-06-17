package inClasstesting3;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		takeScreenShot("Login Page for SauceLabs Demo");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		takeScreenShot("Enter UserName");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		takeScreenShot("Enter Password");
		driver.findElement(By.id("login-button")).click();
		takeScreenShot("Clicked on Login Button and Landed on Home Page");
	}
	
	
	
	public static void takeScreenShot(String FileName) throws InterruptedException {
		Thread.sleep(3000);
		LocalDateTime currentTime= LocalDateTime.now();
		System.out.println(currentTime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MMM_dd_HH_mm_ss");
		String ScreenShotTimeDate= currentTime.format(formatter);
		System.out.println(ScreenShotTimeDate);		
				
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		File Destination = new File("C:\\Users\\glend\\eclipse-workspace\\SeleniumTutorials\\ScreenShots\\"+ScreenShotTimeDate+"_"+FileName+".png");                              
			
		try {
			FileUtils.copyFile(source, Destination);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Screen Shot Taken for "+FileName);
		}
			
				
		
	}

}
