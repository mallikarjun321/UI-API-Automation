package UI_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webdriver_commands {

	public static WebDriver driver;
	
	@Test
	public void TC1() {
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\jars\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		System.out.println("Mallikarjun");
	}
}
