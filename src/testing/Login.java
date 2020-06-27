package testing;

import org.testng.annotations.BeforeTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Login extends OpenWebsite {

	@BeforeTest
	public void TestLogin() throws Exception {

		System.out.println("Login ..");

		try {
			//Click account tab in navbar
			driver.findElement(By.id("header-account-menu")).click();
			//Click signin
			driver.findElement(By.id("account-signin")).click();
			//Wait login form to appear
			Thread.sleep(1000);
			//Click on the email field
			driver.findElement(By.id("gss-signin-email")).click();
			//Write email address
			driver.findElement(By.id("gss-signin-email")).sendKeys("Abdelrahman155295@bue.edu.eg");
			//Click on the password field
			driver.findElement(By.id("gss-signin-password")).click();
			//Write the password
			driver.findElement(By.id("gss-signin-password")).sendKeys("asdfg12345");
			//Click on submit button
			driver.findElement(By.id("gss-signin-submit")).click();
			//Wait 2 minutes
			Thread.sleep(2*60*1000);


			// Make sure the sign in completed
			Boolean result = driver.findElement(By.xpath("//*[@id=\"userGreetingName\"]")).isDisplayed();
			
			if (result) {
				System.out.println("Login Success");
			} else {
				System.out.println("Login Failed");
			}
			
			Assert.assertTrue(result);

		} catch (InterruptedException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
