package inClasstesting3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlings {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement ele = driver.findElement(By.name("submit"));
		ele.click();

		Alert alert = driver.switchTo().alert();
		// 1. alert.accept();
		// 2. alert.dismiss();
		// 3. alert.getText();
		// 4. alert.sendKeys("NIkhil");
		String str = alert.getText();
		System.out.println(str);
		Thread.sleep(3000);
		if (str.equals("Do you really want to delete this Customer?")) {

			alert.dismiss();

		}
		Thread.sleep(3000);
		ele.click();
		Thread.sleep(3000);
		if (str.equals("Do you really want to delete this Customer?")) {

			alert.accept();

		}
		Thread.sleep(3000);

		alert.accept();
		//alert.sendKeys("");
		
		
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(3000);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
*/
		driver.get("https://html.com/input-type-file/");		
			
		WebElement ele=driver.findElement(By.id("fileupload"));
		
		ele.sendKeys("C:\\ARC\\ARC Documents\\Java PPT\\Day 1 - Selenium.pptx");
		
	}

}
