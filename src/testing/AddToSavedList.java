package testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToSavedList extends OpenWebsite {

	@Test(priority=1)
	public void TestAddToSavedList() {

		System.out.println("Add To Saved List ..");

		try {
			// select hotels button
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id=\"tab-hotel-tab-hp\"]/span[2]")).click();

			// select search box
			Thread.sleep(1000);
			driver.findElement(By.id("hotel-destination-hp-hotel")).click();

			// enter destination to search for it
			Thread.sleep(1000);
			driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("Egypt");

			// select first item in recomendation list
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"aria-option-0\"]/div[2]")).click();

			// press search button
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//button[@data-gcw-change-submit-text=\"Search\"])")).click();

			//wait
			Thread.sleep(10000); 

			//add to saved items
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[1]/div[1]/main/div/div/div[2]/section[2]/ol/li[1]/div/div/section/header/div/span[2]/section/div[2]/div/label/div/span[2]")).click();

			// make sure that it was added by checking for the appearence of the pop up
			Thread.sleep(700);
			Boolean Result = driver.findElement(By.className("uitk-toast-enter-done")).isDisplayed();


			if (Result)
				System.out.println("Add To Saved List Sucess ");
			else
				System.out.println("Add To Saved List Failed ");

			Assert.assertTrue(Result);
			
			
		} catch (InterruptedException ex) {
			Logger.getLogger(AddToSavedList.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}

