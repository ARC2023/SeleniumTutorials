package SeleniumTutorialsARC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPart1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(3000);
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		List<WebElement> OptionsDays = driver.findElements(By.xpath("//select[@id='day']//option"));
		List<WebElement> OptionsMonths = driver.findElements(By.xpath("//select[@id='month']//option"));
		List<WebElement> OptionsYears = driver.findElements(By.xpath("//select[@id='year']//option"));

		Select days = new Select(day);
		// days.selectByVisibleText("7");
		// days.selectByValue("7");
		// days.selectByIndex(7);

		Select months = new Select(month);
		// months.selectByVisibleText("Jun");
		// months.selectByValue("6");
		// months.selectByIndex(9);

		Select years = new Select(year);
		// years.selectByVisibleText("1997");
		// years.selectByValue("1997");
		// years.selectByIndex(30);
		/*
		  //Hard Coded 
		   selectDropDownValue(day, "15"); 
		   selectDropDownValue(month, "Dec"); 
		   selectDropDownValue(year, "1993");
		  
		  String dob="15-Feb-1991";
		  
		  String DOB[]=dob.split("-");
		  
		  //Dynamic value 
		   selectDropDownValue(day, DOB[0]); 
		   selectDropDownValue(month,DOB[1]); 
		   selectDropDownValue(year, DOB[2]);
		
		// GetOptions
		List<WebElement> lister = days.getOptions();
		for (WebElement element : lister) {

			if (element.getText().equals("23")) {
				element.click();
				break;
			} else {
				System.out.println(element.getText());
			}
		}
		dropdownByList(days.getOptions(), "18");
		dropdownByList(months.getOptions(), "May");
		dropdownByList(years.getOptions(), "1990");
		
		
		dropdownByList(OptionsDays, "19");
		dropdownByList(OptionsMonths, "Dec");
		dropdownByList(OptionsYears, "1996");
		 */
		
		System.out.println(days.isMultiple());
		
	}

	public static void selectDropDownValue(WebElement ele, String value) {
		Select selector = new Select(ele);
		selector.selectByVisibleText(value);

	}

	public static void dropdownByList(List<WebElement> ele, String value) {

		for (WebElement element : ele) {
			if (element.getText().equals(value)) {
				element.click();
				break;
			} else {
				System.out.println(element.getText());
			}
		}

	}
	
	

}
