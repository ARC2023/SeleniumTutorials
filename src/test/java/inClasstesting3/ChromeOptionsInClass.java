package inClasstesting3;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsInClass {

	public static void main(String[] args) {
		
		//https://peter.sh/experiments/chromium-command-line-switches/
		
		ChromeOptions options= new ChromeOptions();
		
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", 
				Arrays.asList("disable-popup-blocking", "enable-automation"));
		options.addArguments("--incognito");
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement disbabled= driver.findElement(By.xpath("//input[@value='cabbage']"));
		WebElement enabled= driver.findElement(By.xpath("//input[@value='pumpkin']"));
		WebElement notSelected= driver.findElement(By.xpath("//input[@value='option-2']"));
		WebElement displayed = driver.findElement(By.xpath("//input[@value='option-2']//parent::label"));
		
		 boolean value = disbabled.isEnabled();		 
		 System.out.println(value);
		 value=enabled.isEnabled();
		 System.out.println(value);
		 
		 value=enabled.isSelected();
		 System.out.println(value);
		 value=notSelected.isSelected();		 
		 System.out.println(value);
		 
		 value=displayed.isDisplayed();
		 System.out.println(value);
	}

}
