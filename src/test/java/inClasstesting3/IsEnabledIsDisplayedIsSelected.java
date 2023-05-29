package inClasstesting3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabledIsDisplayedIsSelected {
	static boolean value;
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement disbabled= driver.findElement(By.xpath("//input[@value='cabbage']"));
		WebElement enabled= driver.findElement(By.xpath("//input[@value='pumpkin']"));
		WebElement notSelected= driver.findElement(By.xpath("//input[@value='option-2']"));
		WebElement displayed = driver.findElement(By.xpath("//input[@value='option-2']//parent::label"));
		/*
		 value=disbabled.isEnabled();		 
		 System.out.println(value);
		 value=enabled.isEnabled();
		 System.out.println(value);
		 
		 value=enabled.isSelected();
		 System.out.println(value);
		 value=notSelected.isSelected();		 
		 System.out.println(value);
		 */
		 value=displayed.isDisplayed();
		 System.out.println(value);
		 
		 
	}

}
