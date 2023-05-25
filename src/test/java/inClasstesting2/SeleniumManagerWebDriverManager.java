package inClasstesting2;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumManagerWebDriverManager {

	public static void main(String[] args) {
		//System.out.println(SeleniumManager.getInstance().getDriverPath("chromedriver"));
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		//option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", 
				Arrays.asList("disable-popup-blocking", "enable-automation"));
			option.addArguments("--remote-allow-origins=*");
			//WebDriver driver= new ChromeDriver(option);
		
WebDriver driver=WebDriverManager.chromedriver().capabilities(option).create();
		//WebDriver driver=WebDriverManager.chromedriver().create();		
		driver.get("https://www.naukri.com/");
		System.out.println(driver.getCurrentUrl());

	}

}
