package SeleniumTutorialsARC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;


public class LaunchingBrowserDriverMethods {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\ARC\\chromedriver_win32_2.9\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup();
		WebDriverManager.safaridriver().setup();
		WebDriverManager.operadriver().setup();
		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver = new EdgeDriver();
		driver = new InternetExplorerDriver();
		driver = new SafariDriver();
	
				
		driver.get("https://www.amazon.in/");
		System.out.println("Current URL -> "+driver.getCurrentUrl());
		System.out.println("Page Source -> "+	driver.getPageSource());	
		
		driver.manage().addCookie(null);
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookie(null);
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("URL");
				
		
		driver.getWindowHandle();
		driver.getWindowHandles();		
		driver.switchTo().window("Hanlde");
		
		driver.switchTo().alert();
		
		
		driver.switchTo().frame(0);
		driver.switchTo().frame("Frame");
		driver.switchTo().frame(driver.findElement(By.id("wer")));
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		
		driver.close();
		driver.quit();
	
		System.out.println(driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		WebElement UN=driver.findElement(By.id("123"));
		
		
		
		WebElement ele=driver.findElement(By.xpath(""));
		ele.clear();
		ele.click();
		ele.sendKeys("Value to text box");
		ele.getTagName();
		ele.getText();
		ele.isSelected();
		ele.isEnabled();
		ele.isDisplayed();
		ele.getAttribute("innerHTML");
	
		
		
			
		
	}

}
