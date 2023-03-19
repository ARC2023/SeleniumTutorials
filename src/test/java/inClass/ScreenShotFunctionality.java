package inClass;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShotFunctionality {
static WebDriver driver;
	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		option.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		Thread.sleep(2000);
		captureScreenShot("Login Page At Naukri.com");
		

	}
	
	
	public static void captureScreenShot(String FileName) throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile= new File("C:\\CloningWorkSpace\\Selenium\\ScreenShots\\"+FileName+".jpg");		
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Screen Shot Taken for -->"+FileName);
		
		
		
	}
	

}
