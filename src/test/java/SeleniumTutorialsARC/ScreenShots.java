package SeleniumTutorialsARC;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShots {
static WebDriver driver ;
	public static void main(String[] args) throws Exception {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		driver = new ChromeDriver(option);
		driver.get("https://www.naukri.com/");
		Thread.sleep(2000);
		takeScreenShot("Naukri Login Page");
		
	}
	
	public static void takeScreenShot(String fileName) throws IOException {
		LocalDateTime timestamp = LocalDateTime.now();
		System.out.println(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MMM_dd_HH_mm_ss");
        String formattedTimestamp = timestamp.format(formatter);
        System.out.println(formattedTimestamp);
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desFile= new File("C:\\Users\\glend\\eclipse-workspace\\SeleniumTutorials\\ScreenShots\\"+formattedTimestamp+"_"+fileName+".jpg");
		FileUtils.copyFile(srcFile, desFile);
		System.out.println("Screen Shot Taken");
	}

}
