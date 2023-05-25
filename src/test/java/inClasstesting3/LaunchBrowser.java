package inClasstesting3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		System.out.println(driver);
		driver.get("https://www.saucedemo.com/");
		/*System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());		
		//driver.close();		
		//driver.quit();
		//System.out.println(driver);
		
		/*driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//Thread.sleep(3000);
		//driver.navigate().refresh();
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();	
		//driver.close();
		driver.navigate().to("https://www.google.com/");
		
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
		driver.manage().window().minimize();
		*/
		
		
		
		
		
	}

}
