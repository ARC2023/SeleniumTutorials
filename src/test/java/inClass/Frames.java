package inClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");

		int sizeOfFrame = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Count OF Frame-->" + sizeOfFrame);
		int sizeofImage = driver.findElements(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"))
				.size();

		for (int i = 0; i < sizeOfFrame ; i++) {
			driver.switchTo().frame(i);// index
			if(driver
					.findElements(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).size()>0) {
				System.out.println("Case Pass");	
			}else {
				System.out.println("No Element found");
			}
			
			driver.switchTo().defaultContent();
		}

		/*
		 * driver.switchTo().frame("a077aa5e"); driver.findElement(By.xpath(
		 * "//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
		 * driver.switchTo().frame(0);//index driver.switchTo().frame("a077aa5e");//id
		 * or name driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));//
		 * xpath/element
		 */
	}

}
