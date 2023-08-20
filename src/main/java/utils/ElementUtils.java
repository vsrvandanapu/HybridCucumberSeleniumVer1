package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public void clickOnWebElement(WebElement ele, long durationInSeconds) {

		WebElement webElement = waitForElement(ele, durationInSeconds);
		webElement.click();
	}

	public void TypeTextIntoWebElement(WebElement ele, long durationInSeconds, String textTobeType) {
		WebElement webElement = waitForElement(ele, durationInSeconds);
		webElement.sendKeys(textTobeType);
	}

	public String getTextFromWebElement(WebElement ele, long durationInSeconds) {
		WebElement webElement = waitForElement(ele, durationInSeconds);
		return webElement.getText();
	}

	public boolean displyStatusofWebElement(WebElement ele, long durationInSeconds) {
		try {
			WebElement webElement = waitForElement(ele, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return false;
	}

	public void selectOptionInDropdown(WebElement ele, long durationInSeconds, String dropdownOption) {
		WebElement webElement = waitForElement(ele, durationInSeconds);
		Select sel = new Select(webElement);
		sel.selectByValue(dropdownOption);
	}

	public void selectOptionInDropdown(WebElement ele, long durationInSeconds, int indexNo) {
		WebElement webElement = waitForElement(ele, durationInSeconds);
		Select sel = new Select(webElement);
		sel.selectByIndex(indexNo);
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;

	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	public WebElement waitForVisibilityOfWebElement(WebElement ele, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void mouseHoverAndClick(WebElement ele, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfWebElement(ele, durationInSeconds);
		Actions act = new Actions(driver);
		act.moveToElement(webElement).click().build().perform();
	}

	public void javascriptexecutorClick(WebElement ele, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfWebElement(ele, durationInSeconds);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	public void javascriptexecutorType(WebElement ele, long durationInSeconds, String textTobeType) {

		WebElement webElement = waitForVisibilityOfWebElement(ele, durationInSeconds);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+textTobeType+"'", webElement);
	}
}
