package SeleniumTutorialsARC;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlings {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.name("emailid")).sendKeys("arc@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				// Closing the Child Window.
				driver.close();
			}
		}
		// Switching to Parent window i.e Main Window.
		System.out.println("Not Switching to Main window and clicking click");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.switchTo().window(MainWindow);
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
	}

}
