package testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromSavedList extends OpenWebsite {

	@Test(priority=4)
	public void TestRemoveFromSavedList() {
		
		System.out.println("Remove From Saved List ..");
		
		try {
			Thread.sleep(2000);           

			//press x icon at top of the item to remove it from saved items
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".uitk-icon-xsmall:nth-child(1) path")).click();

			//make sure the item div was deleted
			Thread.sleep(2000);
			
			String Actual = driver.findElement(By.className("saved-list")).getText();
			String Expected = "Stella Di Mare Gardens Resort & Spa - Makadi Bay has been removed from all saved items Undo";
			if (Actual.equals(Expected)) {
				System.out.println("Remove From Saved List Success");
			} else {
				System.out.println("Remove From Saved List Failed");
			}
			
			Assert.assertEquals(Actual, Expected);
			
		} catch (InterruptedException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
