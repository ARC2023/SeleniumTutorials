package inClasstesting3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("https://www.nseindia.com/");		
		WebElement marketData=driver.findElement(By.xpath("//a[text()='Market Data']"));
		WebElement preOpenMarket=driver.findElement(By.xpath("//a[text()='Pre-Open Market']"));
		
		
		Actions mouse=new Actions(driver);
		
		// 1. Move To Element / Hover
		
		mouse.moveToElement(marketData).build().perform();
		System.out.println("Hoverred");
		
		// 2. Click 
		Thread.sleep(2000);
		mouse.click(preOpenMarket).build().perform();
		System.out.println("Clicked");
		
		// 3. Drag and Drop Traditional using ClickAndHold , Release
		Actions mouse=new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));		
		WebElement source= driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement destination= driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		mouse.
		clickAndHold(source).
		moveToElement(destination).
		release().
		build().
		perform();
		
		System.out.println("Drag adnd Dropped");
		
		// 4. Drag Drop New Approach
		
		mouse.dragAndDrop(source, destination).build().perform();

		System.out.println("Drag and Dropped");
		
		// 5. Context Click
		Actions mouse=new Actions(driver);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click me']"));
		
		for(int i=0;i<100;i++) {
			mouse.click(rightClick).build().perform();
			System.out.println("Clicking"); 
		}
		
		mouse.contextClick(rightClick).build().perform();
		
		
		// 6. Double Click
		Actions mouse=new Actions(driver);
	driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");		
		WebElement doubleClick=driver.findElement(By.xpath("//h2[text()='Dropdown Menu(s)']"));
		
		mouse.doubleClick(doubleClick).build().perform();
		*/
		
		// 7. Scroll To Element
		Actions mouse=new Actions(driver);
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C589460569849%7Cb%7Cfacebook%20%27%7C&placement=&creative=589460569849&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-327195741349%26loc_physical_ms%3D9303927%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwyqWkBhBMEiwAp2yUFriW6qSst3WCXJQRwZzA6L-LM_TMffZs2MRAg4LMhYJBC54dadDO_hoCZCYQAvD_BwE");
		WebElement scroller= driver.findElement(By.xpath("//span[text()=' Meta © 2023']"));
		
		//mouse.scrollToElement(scroller).build().perform();
		
		// 8. SendKeys, KeyUp, KeyDown
		Thread.sleep(2000);
		WebElement FN=driver.findElement(By.xpath("//input[@name='firstname']"));
		
		//mouse.sendKeys(FN,"indrajeet").build().perform();
		
		mouse.
		moveToElement(FN).
		keyDown(FN, Keys.SHIFT).
		sendKeys(FN, "indrajeet").
		keyUp(FN, Keys.SHIFT).
		contextClick(FN).
		build().
		perform();
		
		
	}

}
