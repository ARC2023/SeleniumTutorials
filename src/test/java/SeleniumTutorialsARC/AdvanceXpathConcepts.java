package SeleniumTutorialsARC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AdvanceXpathConcepts {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get("https://demo.guru99.com/V1/index.php");
		// driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		driver.get("https://www.saucedemo.com/");
		driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());		
		// 0. And / Or
		//driver.findElement(By.xpath("//input[@class='input_error form_input' and @id='password']")).sendKeys("Testing");//		driver.get("https://www.saucedemo.com/");
		// 1. Contains
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("Testing1234");
		//		driver.get("https://www.saucedemo.com/");		
		// 2. Text()
		//driver.findElement(By.xpath("//label[text()='User-ID must not be blank']")).getText();//driver.get("https://demo.guru99.com/V1/index.php");
		// 3. Contains + text()
		//driver.findElement(By.xpath("//label[contains(text(),'Password must not')]")).getText();//driver.get("https://demo.guru99.com/V1/index.php");
		
		// 4. Starts-with
		//driver.findElement(By.xpath("//a[starts-with(text(),'TATA')]")).getText();
		
	    // 5. Dynamic Xpath
		//driver.findElement(By.xpath("//a[text()='TCS']//parent::td//preceding-sibling::td//button//span")).click();
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		//driver.findElement(By.xpath("//a[text()='TCS']//parent::td//following-sibling::td"));
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		
		// 6. Indexing
		//driver.findElement(By.xpath("(//a[text()='TCS']//parent::td//following-sibling::td)[4]"));
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		//(a[text()='TCS']//parent::td//following-sibling::td)[5]
		
	    // 7. Xpath Axes
		//7.1 Following: -Select all nodes that come after the current node
		//driver.findElement(By.xpath("//input[@type='text']//following::input"));	
		//driver.get("https://demo.guru99.com/V1/index.php");	
		//7.2 Preceding: -Select all nodes that come before the current node
		//driver.findElement(By.xpath("input[@type='reset']//preceding::input"));
		// driver.get("https://demo.guru99.com/V1/index.php");
		
		//7.3 Following (with -sibling): -Select the following siblings of the context node. 
		//Siblings are at the same level of the current nod. It will find the element after the current node.
		//driver.findElement(By.xpath("//input[@type='submit']//following-sibling::input"));
		// driver.get("https://demo.guru99.com/V1/index.php");
		//7.4 Preceding (with -sibling): -Select the preceding siblings of the context node. Siblings are at the same level of the current nod. It will find the element before the current node.
		//driver.findElement(By.xpath("//input[@type='reset']//preceding-sibling::input"));
		// driver.get("https://demo.guru99.com/V1/index.php");	
		
		//7.5 Parent: -Selects the parent of the current node.
		//driver.findElement(By.xpath("//a[text()='TCS']//parent::td"));
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		//7.6 Child: -Selects all children elements of the current node.
		//driver.findElement(By.xpath("//ul[@id='java_technologies']//child::li"));
		// driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		
		//7.7 Ancestor: -The ancestor axis selects all ancestors element (grandparent, parent, etc.) of the current node
		//driver.findElement(By.xpath("//ul[@id='java_technologies']//ancestor::div"));
		// driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		//7.8 Descendant: - Selects the descendants of the current node 
		//driver.findElement(By.xpath("//div[@class='featured-box']//descendant::ul"));
		// driver.get("https://demo.guru99.com/test/selenium-xpath.html");
		
		/*Q)How to handle dynamic WebTable In Selenium

		There are two ways of handling WebTable:

		Method � 1:
		� Iterate row and column and get the cell value. 
		� Using for loop
		� Get total rows and iterate table
		� Put if(string matches) then select the respective checkbox
		� Lengthy method
//driver.findElement(By.xpath("//a[text()='TCS']//parent::td//preceding-sibling::td//button//span")).click();
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		//driver.findElement(By.xpath("//a[text()='TCS']//parent::td//following-sibling::td"));
		//driver.get("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
		
		Method � 2:
		� Using custom XPath 
		� Using parent and preceding-sibling tags
		� No need to write for loop
		� No full iteration of table
		� Single line statement
		� More dynamic
		� Efficient and fast
		*/
		List<WebElement> ele22 = driver.findElements(By.xpath("//table[@id='livePreTable']//tbody//tr"));
		
		String str1="//table[@id='livePreTable']//tbody//tr[";
		String str2 = "]//td[2]//a";
		
		       
		for(int i=0;i<ele22.size();i++) {
			
			String xpathExp=str1+i+str2;
			
			WebElement rows=driver.findElement(By.xpath(xpathExp));
			
			String value=rows.getText();
			
			
			if(value.equals("TCS")) {
				
				
			}
		}
	}

}
