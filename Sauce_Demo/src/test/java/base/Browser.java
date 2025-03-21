package base;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public WebDriver driver;
	private String baseurl = "https://www.saucedemo.com/";

	@BeforeClass
	public void browserLaunch() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Navigate to the URL
			driver.get(baseurl);

			// Check if the page loaded correctly
			if (!driver.getCurrentUrl().contains(baseurl)) {
				throw new Exception("Page did not load properly or server is down.");
			}else {
			System.out.println("Browser launched successfully and page loaded.");
			}

		} catch (TimeoutException e) {
			System.out.println("Error: Server took too long to respond. It might be down.");
		} catch (NoSuchElementException e) {
			System.out.println("Error: Unable to find expected elements. The page might not have loaded properly.");
		} catch (Exception e) {
			System.out.println("Browser setup failed: " + e.getMessage());
		}
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
