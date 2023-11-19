package SeleniumTutorialsARC;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("Niks");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		Alert alert = driver.switchTo().alert();
		// 1. alert.accept();
		// 2. alert.dismiss();
		// 3. alert.getText();
		// 4. alert.sendKeys("NIkhil");
		
		if (alert.getText().equals("Do you really want to delete this Customer?")) {
			alert.dismiss();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		if (alert.getText().equals("Do you really want to delete this Customer?")) {
			alert.accept();
		}
		Thread.sleep(3000);
		if (alert.getText().equals("Customer Successfully Delete!")) {
			alert.accept();
		}	
		
		// In case if alert asks for entering a value
		//alert.sendKeys("NIkhil");
		
		// 5. How to upload files 
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("");
		
		// 6. Handling Basic Authentication in popup alert
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(3000);
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
