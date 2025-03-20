package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public WebDriver driver;
	private String baseurl = "https://www.saucedemo.com/";

	@BeforeClass
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // windows maximize
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // driver waits

	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		} else {
			driver = null;
		}
	}
}
