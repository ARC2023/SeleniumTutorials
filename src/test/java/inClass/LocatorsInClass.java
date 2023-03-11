package inClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsInClass {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//1. id		
		//driver.findElement(By.id("user-name")).sendKeys("Rajan");
		
		//2. Classname - Not recommended		
		//driver.findElement(By.className("input_error form_input")).sendKeys("");

		// 3. Name
		
		//driver.findElement(By.name("password")).sendKeys("Anything123");
		
		//4. LinkText
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		//driver.findElement(By.linkText("Conditions of Use")).click();
		
		
		// 5. PatialLinktext
		
		driver.findElement(By.partialLinkText("Help")).click();
		driver.findElement(By.partialLinkText("Other")).click();
		
	}

}
