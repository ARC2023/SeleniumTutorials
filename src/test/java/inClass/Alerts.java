package inClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("8907");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		Alert aa = driver.switchTo().alert();
		Thread.sleep(3000);
		if (aa.getText().equals("Do you really want to delete this Customer?")) {
			aa.dismiss();
		}
		Thread.sleep(3000);
		driver.findElement(By.name("cusid")).clear();
		driver.findElement(By.name("cusid")).sendKeys("8907");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		if (aa.getText().equals("Do you really want to delete this Customer?")) {
			aa.accept();
		}
		
		Thread.sleep(3000);
		if (aa.getText().equals("Customer Successfully Delete!")) {
			aa.accept();
		}
		
		//Prompt Alert
		aa.sendKeys("Value");
		aa.accept();
		
		
	}

}
