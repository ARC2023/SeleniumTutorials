package inClasstesting2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectClass {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		// driver.get("https://www.facebook.com/");
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		WebElement monthly = driver.findElement(By.xpath("//select[@name='Month']"));
		
		 // driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		  Thread.sleep(3000); 
		  /* WebElement day = driver.findElement(By.id("day"));
		  WebElement month = driver.findElement(By.id("month"));
		  WebElement year =  driver.findElement(By.id("year"));
		  
		  
		  Select selectday= new Select(day); 
		  selectday.selectByVisibleText("7");
		  selectday.selectByValue("10"); 
		  selectday.selectByIndex(9);
		  
		  Select selectmonth= new Select(month);
		  selectmonth.selectByVisibleText("Aug"); 
		  selectmonth.selectByValue("9");
		  selectmonth.selectByIndex(7);
		  
		  Select selectyear= new Select(year); 
		  selectyear.selectByVisibleText("1993");
		  selectyear.selectByValue("2000"); 
		  selectyear.selectByIndex(30);
		  */
		  
		  Select selecterday=new Select(monthly);
		  List<WebElement> listByXpath=driver.findElements(By.xpath("//select[@name='Month']//option"));
		  List<WebElement> listByGetOption=selecterday.getOptions();
		  
		
		  iteratorOfSelect(listByXpath,"April");
		  iteratorOfSelect(listByGetOption,"September");
		
		/*
		 * Deselect and Selected value
		Select selectMultiSelect= new Select(monthly);
		
		System.out.println(selectMultiSelect.isMultiple());
		selectMultiSelect.selectByVisibleText("April");
		selectMultiSelect.selectByVisibleText("February");
		selectMultiSelect.selectByVisibleText("November");
		System.out.println("First Select Value-->" + selectByVisibleText.getFirstSelectedOption().getText());
		List<WebElement> selectedValues=selectMultiSelect.getAllSelectedOptions();
		
		for(WebElement ele:selectedValues) {			
			if(ele.getText().equals("April")) {
				System.out.println("Value Found correctly-->"+ele.getText());
			}
			else {
				System.out.println("Value found but ->"+ele.getText());
			}
		}
		
		
		Thread.sleep(3000);
		
		selectMultiSelect.deselectByIndex(4);
		selectMultiSelect.deselectByValue("Feb");
		selectMultiSelect.deselectByVisibleText("November");
*/
		
		
	}
	
	public static void iteratorOfSelect(List<WebElement> selectedValues,String value) {
		
		  for(WebElement ele:selectedValues) {			
				if(ele.getText().equals(value)) {
					ele.click();
					break;
				}
				else {
					System.out.println("Value Not found ->"+ele.getText());
				}
			}
	}

}
