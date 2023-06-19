package inClasstesting3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		WebElement dropdown=driver.findElement(By.name("Month"));
		
		Select months= new Select(dropdown);

		System.out.println("Is Multi Select -->"+months.isMultiple());
		
		
		months.selectByValue("May");
		months.selectByIndex(3);
		months.selectByVisibleText("July");
		
		Thread.sleep(5000);
		List<WebElement> lister=months.getAllSelectedOptions();
		for(WebElement ele:lister) {
			System.out.println(ele.getText());
		}
		System.out.println(months.getFirstSelectedOption().getText());
		
		months.deselectAll();
		
		
		
		Thread.sleep(5000);
		months.selectByIndex(3);
		months.selectByValue("May");
		months.selectByVisibleText("July");
		Thread.sleep(3000);
		months.deselectByIndex(3);
		Thread.sleep(3000);
		months.deselectByValue("May");
		Thread.sleep(3000);
		months.deselectByVisibleText("July");
		
		
	}

}
