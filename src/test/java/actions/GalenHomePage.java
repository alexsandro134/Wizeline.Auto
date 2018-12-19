package actions;

import org.openqa.selenium.WebDriver;

public class GalenHomePage extends CommonsFunction {

	WebDriver driver;

	public GalenHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void inputTextToInput(String locator, String text) {
		sendkeyToElement(driver, locator, text);
	}

	public void clickLoginBtn(String locator) {
		clickToElement(driver, locator);
	}
}
