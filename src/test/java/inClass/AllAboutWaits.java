package inClass;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumTutorialsARC.JavaScriptExecutorMethods;
import io.netty.util.internal.StringUtil;

public class AllAboutWaits {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");

		/*
		 * driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 */
		 // driver.get("https://www.nseindia.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1. Visibility
		WebElement logInBtn=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login_Layer"))));
		//logInBtn.click();
		/*
		// Try iterating at home
		System.out.println(wait
				.until(ExpectedConditions
						.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='ntc__chips-row']"))))
				.size());

		
		  wait.until(ExpectedConditions.
				  visibilityOfElementLocated(By.xpath("//a[@id='login_Layer']"))).click(); 
		  System.out.println(wait
		  .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				  By.xpath("//div[@class='ntc__chips-row']"))).size());
		  
		 

		  driver.findElement(By.xpath("//a[text()='Market Data']")).click();
		  driver.findElement(By.xpath("//a[text()='Pre-Open Market']")).click();
		 
		  List<WebElement> preMarket=wait.until(ExpectedConditions.
				  visibilityOfNestedElementsLocatedBy(By.xpath("//div[@class='ntc__chips-row']"),
						  By.xpath("//a")));
		  System.out.println("Size of List-->"+preMarket.size());
		  int counter=1; 
		  for(WebElement ele:preMarket) {
			  try {
				  if(StringUtils.isNotEmpty(ele.getText())) {
				  System.out.println("Element Text @ "+counter+"-->"+ele.getText());
				  counter++;
				  }
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  
		  counter=1;
		  List<WebElement> preMarket1=wait.until(ExpectedConditions.
		  visibilityOfNestedElementsLocatedBy(driver.findElement(By.xpath("//div[@class='ntc__chips-row']"))
		  ,By.xpath("//a")));
		  
		  System.out.println("Size of List-->"+preMarket1.size());
		  for(WebElement ele:preMarket1) {
			  try {
				  if(StringUtils.isNotEmpty(ele.getText())) {
				  System.out.println("Element Text @ "+counter+"-->"+ele.getText());
				  counter++;
				  }
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		   */
		//2. Invisibility
		List<WebElement> lister=driver.findElements(By.xpath("//div[@class='ntc__chips-row']"));
		JavaScriptExecutorMethods.hideElement(driver,logInBtn);
		JavaScriptExecutorMethods.hideElement(driver,lister);
			System.out.println(wait.until(ExpectedConditions.
					invisibilityOf(logInBtn)));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login_Layer"))));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfAllElements(lister)));
			System.out.println(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login_Layer"),"Login")));
			

	}

}
