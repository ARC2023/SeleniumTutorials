package inClasstesting2;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsForChrome {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();		
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		//option.addExtensions(new File("/path/to/extension.crx"));		
		option.setExperimentalOption("excludeSwitches", 
				Arrays.asList("disable-popup-blocking", "enable-automation"));
		//option.addArguments("headless");
		//option.setHeadless(true);
		option.setAcceptInsecureCerts(true);
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.naukri.com/");		
		System.out.println("Current URL"+driver.getCurrentUrl());
		System.out.println("Title"+driver.getTitle());
		System.out.println("WindowHandle"+driver.getWindowHandle());
		//System.out.println("Page Source"+driver.getPageSource());
		
	}

}
