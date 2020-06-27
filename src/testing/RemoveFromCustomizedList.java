package testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCustomizedList extends OpenWebsite {

	@Test(priority=3)
	public void TestRemoveFromCustomizedList() {

		System.out.println("Remove From Customized List ..");

		try {
			Thread.sleep(1000);
			//remove item from Egypt Hotels customized list
			driver.findElement(By.cssSelector("#uitk-tabs-container > div > div.uitk-tabs-pane.active > div > div:nth-child(3) > div > div > div > div.saved-list > div > div.uitk-card.uitk-grid.all-grid-nowrap.uitk-cell.all-y-padding-one.card-hotel-map > div > div > div.uitk-cell.all-x-padding-two > button")).click();

			 
			//make sure it's removed from the list
			Thread.sleep(2000);
			String Actual = driver.findElement(By.cssSelector("#uitk-tabs-container > div > div.uitk-tabs-pane.active > div > div:nth-child(2) > div.uitk-cell.all-cell-fill.all-y-padding-two > div:nth-child(1) > p")).getText();
			String Expected = "No Custom Lists";
			if (Actual.equals(Expected))
				System.out.println("Remove From Customized List Sucess " );
			else
				System.out.println("Remove From Customized List Failed ");
			
			Assert.assertEquals(Actual, Expected);

		} catch (InterruptedException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
