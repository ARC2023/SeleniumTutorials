package SeleniumTutorialsARC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.manager.SeleniumManager;



public class SeleniumManagerCode {

	public static void main(String[] args) {
		
		//System.out.println(SeleniumManager.getInstance().getDriverPath("chromedriver"));
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.selenium.dev/blog/2022/introducing-selenium-manager/");
		System.out.println(driver.getTitle());

		

	}

}
