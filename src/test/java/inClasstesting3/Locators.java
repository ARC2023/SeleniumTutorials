package inClasstesting3;

import java.awt.print.Printable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println(driver);
		/*driver.get("https://www.saucedemo.com/");

		// 1. ID

		WebElement un = driver.findElement(By.id("user-name"));

		un.sendKeys("standard_user");
		//Thread.sleep(3000);
		un.clear();
		// un.sendKeys("standard_user");

		// 2. ClassName

		// pw = driver.findElement(By.className("input_error form_input"));
		
		//pw.sendKeys("secret_sauce");
		//Thread.sleep(3000);
		//pw.clear();
		
		
		// 3. Name
		WebElement pwName = driver.findElement(By.name("password"));
		
		pwName.sendKeys("secret_sauce");*/
		
		// 4. linktext
		/*driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		WebElement linkText = driver.findElement(By.linkText("Create your Amazon account"));
		linkText.click();
		
		// 5. Partial linktext
		
		WebElement PartiallinkText = driver.findElement(By.partialLinkText("Sign "));
		PartiallinkText.click();*/
		
		// 6. Xpath
		
		
		//a. Indexing
		driver.get("https://www.saucedemo.com/");
		
		WebElement UNXpathIndexed1 = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));	
		WebElement PWXpathIndexed2 = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
		
		UNXpathIndexed1.sendKeys("standard_user");
		PWXpathIndexed2.sendKeys("secret_sauce");
		
		// b. And / Or operator
		
		WebElement UNXpath = driver.findElement(By.xpath("//input[@class='input_error form_input'  and  @id='user-name' ]"));	
		WebElement PWXpath = driver.findElement(By.xpath("//input[@class='input_error form_input'  and  @id='password' ]"));
		UNXpath.clear();
		PWXpath.clear();
		UNXpath.sendKeys("Swapnil");
		PWXpath.sendKeys("secret_sauce77777777777777777777777777777777777");
		
		// c. text() - Function
		WebElement passwordLabel = driver.findElement(By.xpath("//h4[text()='Password for all users:']"));
		
		String str=passwordLabel.getText();
		
		if(str.equals("Password for all users:")) {
		System.out.println("Label is correct");
		}
		
		
		// d. contains() - Function
		
		
		//input[contains(@id,'user')]
		//input[contains(@id,'pass')]
		//h4[contains(text(),'Pass')]
		
		
	}

}
