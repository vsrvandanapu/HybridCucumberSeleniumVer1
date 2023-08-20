package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.labelUsernameIsDisplayed());
	}
	@When("^user enters valid email address (.+) into username filed$")
	public void user_enters_valid_email_address_into_username_filed(String validEmail) {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.typeEmailId(validEmail);
	}

	@And("^user enters valid password (.+) into password filed$")
	public void user_enters_valid_password_into_password_filed(String validPasswd) {
		loginPage.typePassword(validPasswd);
	}

	@And("clicks on Login button")
	public void clicks_on_login_button() {
		homePage = loginPage.clickOnLoginButton();
		
	}

	@Then("user should login successfully")
	public void user_should_login_successfully() {
		Assert.assertTrue(homePage.tabHomeIsDisplayed());
	}

	@When("user enters invalid email address {string} into username filed")
	public void user_enters_invalid_email_address_into_username_filed(String invalidEmail) {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.typeEmailId(invalidEmail);
	}

	@And("user enters invalid password {string} into password filed")
	public void user_enters_invalid_password_into_password_filed(String invalidPasswd) {
		loginPage.typePassword(invalidPasswd);
	}

	@Then("user should get a proper warning message about credentials")
	public void user_should_get_a_proper_warning_message_about_credentials() throws InterruptedException {
		Thread.sleep(10000);
		Assert.assertTrue(loginPage.getWarningMessage().contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator."));
		//Assert.fail();
	}

}
