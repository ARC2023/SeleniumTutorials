package SeleniumTutorialsARC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Locators {
	static WebDriver driver;

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println(driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());

		// driver.findElement(By.xpath("//a[@href='https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F']")).click();

		// 1. Xpath
		// Absolute xpath should not be used instead only Relative xpath should be used

		// driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Laptop");

		// 2. id

		//driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

		// 3. Link Text (a tag is used for links)
		//driver.findElement(By.linkText("Create your Amazon account")).click();

		// 4. partial link text
		// driver.findElement(By.partialLinkText("Sign")).click();

		// 5. ClassName (Can be duplicate)

		// driver.findElement(By.className("input_error form_input").click();

		// 6. CSS Selector
		// Rule 
		//if id is present then css selector is --> #{id}
		// if class is present then css selector is --> .{class}
		// driver.findElement(By.cssSelector("#gh-p-1 > a")).click();

		// 7. Name
		 driver.findElement(By.name("field-keywords")).sendKeys("Alpha");

	}

}
