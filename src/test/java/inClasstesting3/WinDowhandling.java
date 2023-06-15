package inClasstesting3;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WinDowhandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		Thread.sleep(3000);
			
		String mainWindow= driver.getWindowHandle();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		
		
		while (itr.hasNext()) {
			String ChildWindow = itr.next();			
			if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				
				try {
				driver.findElement(By.name("emailid")).sendKeys("arc@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(3000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				driver.close();
			}
		}
		Thread.sleep(3000);
		//driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
	}

}
