package inClass;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class isDisplayedisSelectedisDisabled {

	public static void main(String[] args) {

		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement options=driver.findElement(By.xpath("//input[@value='option-2']/.."));
		WebElement options1=driver.findElement(By.xpath("//input[@value='option-2']"));
		WebElement options2=driver.findElement(By.xpath("//input[@value='option-3']"));
		WebElement options3=driver.findElement(By.xpath("//input[@value='cabbage']"));
		
		
		System.out.println(options.isDisplayed());
		System.out.println(options1.isSelected());
		System.out.println(options2.isSelected());
		System.out.println(options3.isEnabled());
		
	}

}
