package testing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UndoRemove extends OpenWebsite {

	@Test(priority=5)
	public void TestUndoRemove() {

		System.out.println("Undo Remove ..");

		try {
			//press undo button to retrive the removed item
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"undo-button\"]/span/u")).click();

			//make sure the item div returned.
			Thread.sleep(5000);
			Boolean Result = driver.findElement(By.xpath("//*[@id=\"uitk-tabs-container\"]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]")).isDisplayed();

			if (Result)
				System.out.println("Undo Remove Sucess " );
			else
				System.out.println("Undo Remove Failed ");
			
			Assert.assertTrue(Result);

		} catch (InterruptedException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
