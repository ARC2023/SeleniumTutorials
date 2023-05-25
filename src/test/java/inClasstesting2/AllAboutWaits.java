package inClasstesting2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
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

	public static void main(String[] args) throws InterruptedException {
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
		// driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		// driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1. Visibility
		// WebElement
		// logInBtn=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login_Layer"))));
		// logInBtn.click();
		/*
		 * // Try iterating at home System.out.println(wait .until(ExpectedConditions
		 * .visibilityOfAllElements(driver.findElements(By.xpath(
		 * "//div[@class='ntc__chips-row']")))) .size());
		 * 
		 * 
		 * wait.until(ExpectedConditions.
		 * visibilityOfElementLocated(By.xpath("//a[@id='login_Layer']"))).click();
		 * System.out.println(wait
		 * .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		 * By.xpath("//div[@class='ntc__chips-row']"))).size());
		 * 
		 * 
		 * 
		 * driver.findElement(By.xpath("//a[text()='Market Data']")).click();
		 * driver.findElement(By.xpath("//a[text()='Pre-Open Market']")).click();
		 * 
		 * List<WebElement> preMarket=wait.until(ExpectedConditions.
		 * visibilityOfNestedElementsLocatedBy(By.xpath("//div[@class='ntc__chips-row']"
		 * ), By.xpath("//a"))); System.out.println("Size of List-->"+preMarket.size());
		 * int counter=1; for(WebElement ele:preMarket) { try {
		 * if(StringUtils.isNotEmpty(ele.getText())) {
		 * System.out.println("Element Text @ "+counter+"-->"+ele.getText()); counter++;
		 * } } catch(Exception e) { e.printStackTrace(); } }
		 * 
		 * counter=1; List<WebElement> preMarket1=wait.until(ExpectedConditions.
		 * visibilityOfNestedElementsLocatedBy(driver.findElement(By.xpath(
		 * "//div[@class='ntc__chips-row']")) ,By.xpath("//a")));
		 * 
		 * System.out.println("Size of List-->"+preMarket1.size()); for(WebElement
		 * ele:preMarket1) { try { if(StringUtils.isNotEmpty(ele.getText())) {
		 * System.out.println("Element Text @ "+counter+"-->"+ele.getText()); counter++;
		 * } } catch(Exception e) { e.printStackTrace(); } }
		 * 
		 * //2. Invisibility List<WebElement>
		 * lister=driver.findElements(By.xpath("//div[@class='ntc__chips-row']"));
		 * JavaScriptExecutorMethods.hideElement(driver,logInBtn);
		 * JavaScriptExecutorMethods.hideElement(driver,lister);
		 * System.out.println(wait.until(ExpectedConditions. invisibilityOf(logInBtn)));
		 * System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated
		 * (By.id("login_Layer"))));
		 * System.out.println(wait.until(ExpectedConditions.invisibilityOfAllElements(
		 * lister))); System.out.println(wait.until(ExpectedConditions.
		 * invisibilityOfElementWithText(By.id("login_Layer"),"Login")));
		 * 
		 * 
		 * // 3. Alerts driver.get("https://demo.guru99.com/test/delete_customer.php");
		 * driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("Niks");
		 * driver.findElement(By.xpath("//input[@name='submit']")).click(); Alert
		 * alert=wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(2000);
		 * alert.accept(); Thread.sleep(2000); alert.dismiss();
		 * 
		 * 
		 * // 4. Element selection state
		 * 
		 * System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe(
		 * By.xpath("//input[@value='option-2']"), false)));
		 * System.out.println(wait.until(ExpectedConditions.elementSelectionStateToBe(
		 * driver.findElement(By.xpath("//input[@value='option-3']")), true)));
		 * 
		 * // 5. Element Click able state
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@value='option-2']"))).click(); WebElement
		 * clickable=wait.until(ExpectedConditions.elementToBeClickable(driver.
		 * findElement(By.xpath("//input[@value='option-3']")))); clickable.click();
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@value='cabbage']"))).click();
		 * 
		 * 
		 * // 6. Element Selected
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@value='option-2']"))).click();
		 * System.out.println(wait.until(ExpectedConditions.elementToBeSelected(By.xpath
		 * ("//input[@value='option-2']"))));
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@value='option-2']"))).click();
		 * System.out.println(wait.until(ExpectedConditions.elementToBeSelected(driver.
		 * findElement(By.xpath("//input[@value='option-2']")))));
		 
		// 7. Frame

		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("a077aa5e")));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("a077aa5e"));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("a077aa5e"))));
		// driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();

		// 8. Presence of element
		WebElement logInBtn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login_Layer"))));
		List<WebElement> lister = driver.findElements(By.xpath("//div[@class='ntc__chips-row']"));
		JavaScriptExecutorMethods.hideElement(driver, logInBtn);
		JavaScriptExecutorMethods.hideElement(driver, lister);
		
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_Layer")));
		System.out.println(ele);
		ele.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ntc__chips-row']")));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.name(""), By.name("")));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(driver.findElement(By.id("")), By.name("")));
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.name(""), By.name("")));

		// 9. text To be present
		
		System.out
				.println(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("login_Layer"), "Login")));
		System.out.println(wait
				.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("login_Layer")), "Login")));
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("arc@gmail.com");
//				wait.until(ExpectedConditions.textToBePresentInElementValue(By.name(""), ""));
		System.out.println(wait.until(ExpectedConditions.textToBePresentInElementValue(
				driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")),
				"FIGMA")));

		
		// 10. Title
				driver.getTitle();
				System.out.println(wait.until(ExpectedConditions.titleContains(driver.getTitle())));
				System.out.println(wait.until(ExpectedConditions.titleIs(driver.getTitle()+"ABCD")));
		*/		
	}

		
}
