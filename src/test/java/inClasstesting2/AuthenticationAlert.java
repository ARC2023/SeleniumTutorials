package inClasstesting2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("C:\\Users\\mohda\\Downloads\\Manual Interview Questions-Set 1.pdf");
		
	}

}
