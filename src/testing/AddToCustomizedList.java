package testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCustomizedList extends OpenWebsite {

	@BeforeMethod
	public void BeforeAddToCustomizedList() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/header/div/div/a/img")).click();
	}

	@Test(priority=2)
	public void TestAddToCustomizedList() {
		
		System.out.println("Add To Customized List ..");
		
		try {

			//select list of favorites
			Thread.sleep(1000);           
			driver.findElement(By.xpath("//*[@id=\"header-history\"]/span[1]")).click();

			//clicks save to list at the desired item
			Thread.sleep(3000); 
			driver.findElement(By.xpath("//*[@id=\"uitk-tabs-container\"]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[2]/div/div/div[1]/div/a")).click();
			// the web site sometimes switch the place of the save to list button from right to left and replace it with a change date (screen shots included in the report) 
			// if this happens use this instead driver.findElement(By.xpath("//*[@id=\"uitk-tabs-container\"]/div/div[1]/div/div[3]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/a")).click();


			//press create new list
			Thread.sleep(2000); 
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div/div/div[3]/div/div/button")).click();

			//select text box
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div/div/div[3]/div/div/div")).click();
			//type list name
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div/div/div[3]/div/div/div/input")).sendKeys("Egypt Hotels");

			//submit
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[4]/div/div[2]/button/span")).click();

			//make sure that the name of the created list is the same added to the item 
			Thread.sleep(2000);
			Boolean result = driver.findElement(By.xpath("//*[@id=\"Egypt Hotels\"]/span/span/span[2]")).isDisplayed();
			if(result)
				System.out.println("Add To Customized List Sucess");
			else
				System.out.println("Add To Customized List Failed");
			
			Assert.assertTrue(result);

		} catch (InterruptedException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}