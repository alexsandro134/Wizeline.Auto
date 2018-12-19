package actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyNotesPage extends CommonsFunction {

	WebDriver driver;

	public MyNotesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyLoginSuccessful(String locator) {
		boolean flag = isControlDisplayed(driver, locator);
		Assert.assertTrue(flag);
	}
	
	public void inputTextToNewNote(String locator, String text) {
		sendkeyToElement(driver, locator, text);
	}
	
	public void clickToAddNewNotes(String locator) {
		clickToElement(driver, locator);
	}
	
	public void verifyNewNoteWasCreated(String titleXpath, String descXpath) {
		boolean titleDisplayed = isControlDisplayed(driver, titleXpath);
		boolean descDisplayed = isControlDisplayed(driver, descXpath);
		if(titleDisplayed == true && descDisplayed == true) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}
}
