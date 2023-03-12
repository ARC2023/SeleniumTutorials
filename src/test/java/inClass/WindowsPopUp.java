package inClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsPopUp {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(3000);

		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window Id" + mainWindow);
		Set<String> windowID = driver.getWindowHandles();

		for (String str : windowID) {
			String childWindow = str;
			int i = 1;
			System.out.println("Iteration No" + i);
			System.out.println("Child Window Id" + childWindow);
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				try {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("arc@yahoo.com");
					Thread.sleep(3000);
					closeAllBrowser(windowID, mainWindow);
				} catch (Exception e) {
					e.printStackTrace();
					driver.close();
				}

			}

		}
		driver.switchTo().window(mainWindow);
		System.out.println("System Should Click Here on Main windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

	}

	public static void closeAllBrowser(Set<String> windowID, String mainWindow) {
		for (String str : windowID) {
			String childWindow = str;
			int i = 1;
			System.out.println("Iteration No" + i);
			System.out.println("Child Window Id" + childWindow);
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				try {
					driver.close();
				} catch (Exception e) {
					e.printStackTrace();
					driver.close();
				}

			}
		}

	}
}
