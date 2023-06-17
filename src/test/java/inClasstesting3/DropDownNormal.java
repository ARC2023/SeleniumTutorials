package inClasstesting3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownNormal {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(4000);
		WebElement days=driver.findElement(By.id("day"));
		WebElement months=driver.findElement(By.id("month"));
		WebElement years=driver.findElement(By.id("year"));
		
		Select daySelection = new Select(days);
		//daySelection.selectByVisibleText("7");
		//Thread.sleep(5000);
		//daySelection.selectByValue("8");
		//Thread.sleep(5000);
		//daySelection.selectByIndex(11);
		
		Select monthSelection = new Select(months);
		System.out.println(monthSelection.isMultiple());
		/*monthSelection.selectByVisibleText("Feb");
		Thread.sleep(5000);
		monthSelection.selectByValue("4");
		Thread.sleep(5000);
		monthSelection.selectByIndex(11);
		*/
		
		Select yearSelection = new Select(years);
		/*yearSelection.selectByVisibleText("2023");
		Thread.sleep(5000);
		yearSelection.selectByValue("2001");
		Thread.sleep(5000);
		yearSelection.selectByIndex(11);
		*/
		/*String dob="28-Feb-1993";
		String DOB[]=dob.split("-");
		for(int i=0;i<DOB.length;i++) {
			System.out.println("Value at "+i+" is  -->"+DOB[i]);
		}
		selectFromDropDown(days, DOB[0]);
		selectFromDropDown(months, DOB[1]);
		selectFromDropDown(years, DOB[2]);
		
		*/
		List<WebElement> lister= daySelection.getOptions();
		for(WebElement ele:lister) {
			
			if(ele.getText().equals("15")) {
				ele.click();
				break;
				
			} else {
				System.out.println(ele.getText());
			}
			
		}
		
	}

	
	public static void selectFromDropDown(WebElement element,String value) throws InterruptedException {
		Select Selection = new Select(element);
		Selection.selectByVisibleText(value);
		Thread.sleep(5000);		
	}
	
	
}
