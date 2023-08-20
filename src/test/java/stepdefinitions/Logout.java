package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class Logout {
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;

	@When("user click the logout link")
	public void user_click_the_logout_link() throws InterruptedException {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		Thread.sleep(5000);
		homePage.clickOnArrowNav();
		Thread.sleep(5000);
		loginPage = homePage.clickOnLogoutLink();
		Thread.sleep(5000);
	}

	@Then("user should be redirected to the login page")
	public void user_should_be_redirected_to_the_login_page() {
		driver = DriverFactory.getDriver();
		Assert.assertTrue(loginPage.labelUsernameIsDisplayed());
	}
}
