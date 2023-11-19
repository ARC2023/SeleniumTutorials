package SeleniumTutorialsARC;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");

		int sizeOfFrame = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Size of Frames-->" + sizeOfFrame);
		/*
		 * Frames handled by By Index By Name or Id By Web Element
		 */

		for (int i = 0; i < sizeOfFrame; i++) {
			driver.switchTo().frame(i);
			List<WebElement> total = driver.findElements(By.xpath("html/body/a/img"));
			int u=total.size();
			System.out.println(total);
			driver.switchTo().defaultContent();
		}
/*
		driver.switchTo().frame("a077aa5e");
		int sd=driver.findElements(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).size();
		System.out.println(sd);
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//font[text()='THIS IS A DEMO PAGE FOR TESTING']")).isDisplayed());
		*/
		//driver.switchTo().defaultContent();

	}

}
