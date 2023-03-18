package inClass;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumManagerWebDriverManager {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", 
				Arrays.asList("disable-popup-blocking", "enable-automation"));
			option.addArguments("--remote-allow-origins=*");
			
		
		WebDriver driver=WebDriverManager.chromedriver().capabilities(option).create();
		
		
		driver.get("https://www.naukri.com/");
		System.out.println(driver.getCurrentUrl());

	}

}
