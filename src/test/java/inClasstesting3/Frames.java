package inClasstesting3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");
		
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		
		int sizeOfFrames=frames.size();
		System.out.println("Size OF Frames-->"+sizeOfFrames);
		
		
		for(int i=0;i<=sizeOfFrames;i++) {	
			//System.out.println(i);
			driver.switchTo().frame(i);		
			
			int total = driver.findElements(By.xpath("html/body/a/img")).size();
			
			
			System.out.println(total);
			driver.switchTo().defaultContent();
		}
		
		
		driver.switchTo().frame("a077aa5e");
		int sd=driver.findElements(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).size();
		System.out.println(sd);
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//font[text()='THIS IS A DEMO PAGE FOR TESTING']")).isDisplayed());
		
	}

}
