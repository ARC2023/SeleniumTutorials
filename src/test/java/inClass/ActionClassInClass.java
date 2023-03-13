package inClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassInClass {
static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.nseindia.com/");
		
		// 1. Move to element / Hover along with click
		
		Actions mouse = new Actions(driver);
		
		//mouse.moveToElement(driver.findElement(By.xpath("//a[text()='Market Data']"))).build().perform();
//		mouse.moveToElement(driver.findElement(By.xpath("//a[text()='Pre-Open Market']"))).click().build().perform();
		
		// 2. Single Click
		
		//WebElement ele=driver.findElement(By.id("usdinr"));		
		
		//mouse.click(ele).build().perform();
		
		// 3. Double Click
		/*
		 * driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement ele1=driver.findElement(By.xpath("//h1[text()='Dropdown Menu(s), Checkboxe(s) & Radio Button(s)']"));
		mouse.doubleClick(ele1).build().perform();*/
		
		// 4. Right Click		
		/*driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement ele2=driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement copy=driver.findElement(By.xpath("//span[text()='Copy']"));
		mouse.contextClick(ele2).click(copy).build().perform();
		*/
		// 5. SendKeys
		
		/*driver.get("https://www.saucedemo.com/");
		WebElement ele3=driver.findElement(By.id("user-name"));
		
		mouse.sendKeys(ele3, "ARC2023").sendKeys(Keys.ENTER).build().perform();
		mouse.sendKeys(ele3, "ARC2023").sendKeys(Keys.TAB).build().perform();*/
		
		// 6. Drag and Drop - Traditional Way ( Move to element + ClickAndHold(Source) + Move to element(Target) + Release
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop=driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		//mouse.clickAndHold(drag).moveToElement(drop).release().build().perform();
		
		// 7. Drag and Drop - Direct Method Way
		mouse.dragAndDrop(drag, drop).build().perform();
		
		// 8. Scroll to element
		
		// 9. Action Builder
		
	}

}
