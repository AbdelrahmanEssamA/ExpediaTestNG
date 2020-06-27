package testing;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebsite {
	public static WebDriver driver;

	@BeforeSuite
	public void testOpenURL() {

		System.out.println("Open URL");

		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open expedia home page
		driver.navigate().to("https://www.expedia.com/");
		//Maxmize the page
		driver.manage().window().maximize();

		System.out.println("URL is Opened");
	}

	@AfterSuite
	public void testCloseBrowser() throws Exception {
		System.out.println("Close Browser");
		driver.close();
		System.out.println("Browser is Closed");
	}

}
