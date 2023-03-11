package inClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {

	public static void main(String[] args) {
	
		
		//System.setProperty("webdriver.chrome.driver","C:\\ARC\\chromedriver_win32_2.9\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		//driver.get("https://www.saucedemo.com/");
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		System.out.println(driver.getCurrentUrl());		
		//driver.manage().addCookie(null);
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookie(null);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();		
		//driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		/*
		 * driver.navigate().refresh(); driver.navigate().to("https://www.amazon.in/");
		 * driver.navigate().back(); driver.navigate().forward();
		 */
		//System.out.println(driver);
		//.close();
		//System.out.println(driver);
		System.out.println(driver.findElement(By.xpath("//input[@name='vegetable' and @value='cabbage']")).isEnabled());
	
	}

}
