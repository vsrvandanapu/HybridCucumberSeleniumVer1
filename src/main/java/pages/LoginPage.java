package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
//		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//label[text()='Username']") private WebElement labelUsername;
	@FindBy(id="username") private WebElement txtBoxUsername;
	@FindBy(id="password") private WebElement txtboxPassword;
	@FindBy(xpath="//input[@id='Login']") private WebElement btnLogin;
	@FindBy(xpath="//div[@id='error']") private WebElement warningMessage;
	
	public boolean labelUsernameIsDisplayed() {
		return elementUtils.displyStatusofWebElement(labelUsername, CommonUtils.EXPLICIT_WAIT_TIME);
		//return labelUsername.isDisplayed();
	}
	
	public void typeEmailId(String validEmail) {
		elementUtils.TypeTextIntoWebElement(txtBoxUsername, CommonUtils.EXPLICIT_WAIT_TIME, validEmail);
		//txtBoxUsername.sendKeys(validEmail);
	}
	
	public void typePassword(String validPassword) {
		elementUtils.TypeTextIntoWebElement(txtboxPassword, CommonUtils.EXPLICIT_WAIT_TIME, validPassword);
		//txtboxPassword.sendKeys(validPassword);
	}
	
	public HomePage clickOnLoginButton() {
		elementUtils.clickOnWebElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
		//btnLogin.click();
		return new HomePage(driver);
	}
	public HomePage loginToApplication(String validEmail, String validPassword) {
		elementUtils.TypeTextIntoWebElement(txtBoxUsername, CommonUtils.EXPLICIT_WAIT_TIME, validEmail);
		elementUtils.TypeTextIntoWebElement(txtboxPassword, CommonUtils.EXPLICIT_WAIT_TIME, validPassword);
		elementUtils.clickOnWebElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
//		txtBoxUsername.sendKeys(validEmail);
//		txtboxPassword.sendKeys(validPassword);
//		btnLogin.click();
		return new HomePage(driver);
	}
	public HomePage loginToApplication() {
		elementUtils.TypeTextIntoWebElement(txtBoxUsername, CommonUtils.EXPLICIT_WAIT_TIME, "srinivas@cisolutions.com");
		elementUtils.TypeTextIntoWebElement(txtboxPassword, CommonUtils.EXPLICIT_WAIT_TIME, "Selenium@1");
		elementUtils.clickOnWebElement(btnLogin, CommonUtils.EXPLICIT_WAIT_TIME);
//		txtBoxUsername.sendKeys("srinivas@cisolutions.com");
//		txtboxPassword.sendKeys("Selenium@1");
//		btnLogin.click();
		return new HomePage(driver);
	}
	public String getWarningMessage() {
		return elementUtils.getTextFromWebElement(warningMessage, CommonUtils.EXPLICIT_WAIT_TIME);
		//return warningMessage.getText();
	}

}
