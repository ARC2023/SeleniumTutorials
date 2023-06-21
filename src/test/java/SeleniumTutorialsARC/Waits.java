package SeleniumTutorialsARC;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		//option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		//driver.get("https://www.naukri.com/");
		/*driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebDriverWait wait= new WebDriverWait(driver, 200);
		/*
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		System.out.println(driver.getTitle());
		
		
		
		//1. Visibility		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login_Layer")))).click();
		System.out.println(wait.until(ExpectedConditions.visibilityOfAllElements(
				driver.findElements(By.xpath("//div[@class='ntc__chips-row']")))).size());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='login_Layer']"))).click();
		System.out.println(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//div[@class='ntc__chips-row']"))).size());
		
		driver.get("https://www.nseindia.com/");
		driver.findElement(By.xpath("//a[text()='Market Data']")).click();
		WebElement ty=driver.findElement(By.xpath("//a[text()='Pre-Open Market']"));
		wait.until(ExpectedConditions.visibilityOf(ty)).click();		
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
				By.xpath("//table[@id='livePreTable']"), By.xpath("//td//a"))).size());
		System.out.println(wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(
				driver.findElement(By.id("livePreTable")),By.xpath("//td//a"))).size());
		
		
		//2. Invisibility
		System.out.println(wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("login_Layer")))));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='ntc__chips-row']")))));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login_Layer"))));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login_Layer"),"Login")));
		
		// 3. Alerts
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("Niks");
		driver.findElement(By.xpath("//input[@name='submit']")).click();	
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(5000);
		alert.dismiss();
		
		// 4. Element selection state
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//input[@value='option-2']"), false)));
		System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.xpath("//input[@value='option-3']")), true)));
		
		// 5. Element Click able state
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@value='option-3']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='option-2']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='radio-buttons-selected-disabled']/input[2]")))).click();
	 
		
		// 6. Element Selected 
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='option-2']"))).click();
		System.out.println(wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@value='option-2']"))));
		System.out.println(wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//input[@value='option-1']")))));
		
		// 7. Frame
		driver.get("https://demo.guru99.com/test/guru99home/");
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("a077aa5e")));		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("a077aa5e"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("a077aa5e"))));
		driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
		
		
		// 8. Presence of element
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("")));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.name(""), By.name("")));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(driver.findElement(By.id("")),By.name("")));
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.name(""), By.name("")));
		*/
		// 9. text To be present
		driver.get("https://www.naukri.com/");
		System.out.println(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("login_Layer"), "Login")));
		System.out.println(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("login_Layer")), "Login")));
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")).sendKeys("arc11@gmail.com");
//		wait.until(ExpectedConditions.textToBePresentInElementValue(By.name(""), ""));
		System.out.println(wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")), "arc@gmail.com")));
		
		// 10. Title
		driver.getTitle();
		System.out.println(wait.until(ExpectedConditions.titleContains(driver.getTitle())));
		System.out.println(wait.until(ExpectedConditions.titleIs(driver.getTitle())));
		/*
		*/
		
	}
	

}


