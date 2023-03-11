package inClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsIndetails {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//driver.get("https://www.saucedemo.com/");
		/*
		 * WebElement ele=driver.findElement(By.
		 * xpath("//a[@class='nav-a  ' and @data-csa-c-content-id='nav_cs_fashion']"));
		 * String str=ele.getText(); System.out.println(str);
		 * 
		 * if(str.equalsIgnoreCase("fashion")) {
		 * 
		 * throw new Exception("Broken"); }
		 */
		
		//driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("Piyush");
		//driver.findElement(By.xpath("//a[text()='Fashion']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}