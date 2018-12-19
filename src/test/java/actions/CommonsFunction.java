package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonsFunction {

	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String text) {
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		boolean flag = element.isDisplayed();
		if (flag == true) {
			System.out.println("Element with xpath: " + locator + " is displayed");
		} else {
			System.out.println("Element with xpath: " + locator + " is not displayed");
		}
		return flag;
	}
}
