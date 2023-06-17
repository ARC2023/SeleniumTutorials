package SeleniumTutorialsARC;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPart2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		WebElement month = driver.findElement(By.xpath("//select[@name='Month']"));

		Select months = new Select(month);
		months.selectByVisibleText("April");
		months.selectByVisibleText("February");
		months.selectByVisibleText("November");
		Thread.sleep(2000);
		System.out.println(months.isMultiple());
		
		List<WebElement> monthList = months.getAllSelectedOptions();
		for (WebElement ele : monthList) {
			System.out.println("Selected Value-->" + ele.getText());
		}
		System.out.println("First Select Value-->" + months.getFirstSelectedOption().getText());

		// months.deselectAll();
		 months.deselectByIndex(4);
		 months.deselectByValue("Feb");
		 months.deselectByVisibleText("November");

	}

}
