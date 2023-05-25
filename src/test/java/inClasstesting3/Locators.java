package inClasstesting3;

import java.awt.print.Printable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println(driver);
		driver.get("https://www.saucedemo.com/");

		// 1. ID

		WebElement un = driver.findElement(By.id("user-name"));

		un.sendKeys("standard_user");
		//Thread.sleep(3000);
		un.clear();
		// un.sendKeys("standard_user");

		// 2. ClassName

		WebElement pw = driver.findElement(By.className("input_error form_input"));
		
		//pw.sendKeys("secret_sauce");
		Thread.sleep(3000);
		pw.clear();
		
		
		// 

	}

}
