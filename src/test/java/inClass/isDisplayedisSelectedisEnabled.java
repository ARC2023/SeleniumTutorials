package inClass;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class isDisplayedisSelectedisEnabled {

	public static void main(String[] args) {

		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		
		WebElement ele1=driver.findElement(By.xpath("//input[@value='option-2']/.."));
		WebElement ele2=driver.findElement(By.xpath("//input[@value='option-2']"));
		WebElement ele3=driver.findElement(By.xpath("//input[@value='option-3']"));
		WebElement ele4=driver.findElement(By.xpath("//input[@value='cabbage']"));
		WebElement ele5=driver.findElement(By.xpath("//input[@value='pumpkin']"));
		
		
		
		System.out.println(ele1.isDisplayed());
		System.out.println(ele2.isSelected());
		System.out.println(ele3.isSelected());
		System.out.println(ele4.isEnabled());
		System.out.println(ele5.isEnabled());
		System.out.println(ele5.isSelected());
		
	}

}
