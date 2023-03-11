package inClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver","C:\\ARC\\chromedriver_win32_2.9\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		//driver.get("https://www.nseindia.com/");
		System.out.println(driver.getCurrentUrl());
		// driver.manage().addCookie(null);
		driver.manage().deleteAllCookies();
		// driver.manage().deleteCookie(null);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		/*
		 * driver.navigate().refresh(); driver.navigate().to("https://www.amazon.in/");
		 * driver.navigate().back(); driver.navigate().forward();
		 */
		// System.out.println(driver);
		// .close();
		// System.out.println(driver);
		//System.out.println(driver.findElement(By.xpath("//input[@name='vegetable' and @value='cabbage']")).isEnabled());

		// table[@id="livePreTable"]/tbody/tr[1]/td[2]/a
		// table[@id="livePreTable"]/tbody/tr[2]/td[2]/a
		// table[@id="livePreTable"]/tbody/tr[3]/td[2]/a
		
		
		driver.findElement(By.id("user-name")).sendKeys("EuropeZone");
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).clear();
		//driver.findElement(By.id("user-name")).sendKeys(Keys.TAB);
		
		
		
		/*driver.findElement(By.xpath("//a[text()='Market Data']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Pre-Open Market']")).click();
		Thread.sleep(2000);
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@id='livePreTable']/tbody/tr"));
		String firstPart = "//table[@id='livePreTable']/tbody/tr[";
		String lastPart = "]/td[2]/a";

		for (int i = 1; i <= companyNames.size()-1; i++) {

			try {
				
				if(driver.findElement(By.xpath(firstPart + i + lastPart)).getText().
						equalsIgnoreCase("BAJAJ-AUTO")) {
					driver.findElement(By.xpath(firstPart + i + lastPart)).click();
				}else {
					System.out.println(driver.findElement(By.xpath(firstPart + i + lastPart)).getText());
				}
				
			} catch (Exception e) {
					e.printStackTrace();
			}
		}
*/
	}

	
}
