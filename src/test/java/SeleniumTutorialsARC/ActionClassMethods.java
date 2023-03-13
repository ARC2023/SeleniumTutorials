package SeleniumTutorialsARC;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassMethods {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.nseindia.com/");
		
		Actions mouse= new Actions(driver);
		// 1. Move To Element
		/*mouse.moveToElement(driver.
				findElement(By.xpath("//a[text()='Market Data']"))).build().perform();
		
		Thread.sleep(2000);
		// 2. Click using action class
		mouse.click(driver.
				findElement(By.xpath("//a[text()='Derivatives Market']"))).build().perform();
		
		// 3. Drag and Drop traditional way 
		 
		 
		 driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement drag= driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop= driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		/*mouse.clickAndHold(drag).
		moveToElement(drop).
		release().
		build().
		perform();
		
		// 4. Drag and Drop new Way
		
		//mouse.dragAndDrop(drag, drop).build().perform();
		
		// 5. Right Click 
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick= driver.findElement(By.xpath("//span[text()='right click me']"));
		Thread.sleep(2000);
		mouse.contextClick(rightClick).build().perform();
		mouse.clickAndHold(driver.findElement(By.xpath("//span[text()='Copy']"))).release().build().perform();
		
		// 6. Double Click
		
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		mouse.doubleClick(driver.findElement(By.xpath("//input[@value='yellow']"))).build().perform();
*/
		// 7. Action
		String baseUrl = "http://www.facebook.com/"; 
		
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;
		
		// 8. Send Keys
		
		mouse.sendKeys(txtUsername, "Hello").build().perform();
		mouse.sendKeys(txtUsername,Keys.ENTER);
		
		// 9. Scroll to element
		mouse.scrollToElement(driver.findElement(By.xpath("//span[text()=' Meta © 2023']"))).build().perform();
	}

}
