package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;

public class CreateLead {
	
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private LeadsPage leadsPage;
	
	@Given("registered user logged in to salesforce")
	public void registered_user_logged_in_to_salesforce() {
	   driver = DriverFactory.getDriver();
	   loginPage = new LoginPage(driver);
	   homePage = loginPage.loginToApplication();
	  
	}

	@When("user navigate to the leads creation page")
	public void user_navigate_to_the_leads_creation_page() throws InterruptedException {
	  
	   leadsPage= homePage.clickOnLeadsTab();
	   Thread.sleep(5000);
	   homePage.clickOnClosePopup();
	   Thread.sleep(5000);
	   leadsPage.clickOnNewButtonLead();
	   Thread.sleep(5000);
	}
	

	@And("user fill into below details")
	public void user_fill_into_below_details(DataTable dataTable) throws InterruptedException {
	    Map<String, String> map = dataTable.asMap(String.class, String.class);
	    leadsPage.typeFirstname(map.get("firstName"));
	    leadsPage.typeLastname(map.get("lastName"));
	    leadsPage.typeCompanyname(map.get("companyName"));
	    leadsPage.typeEmailid(map.get("email"));
	    leadsPage.selectDropdownLeadStatus(map.get("leadStatus"));
	    Thread.sleep(5000);
	    
	}

	@And("user click the save button")
	public void user_click_the_save_button() throws InterruptedException {
		 leadsPage.clickOnSaveButton();
	   Thread.sleep(5000);
	}

	@Then("the lead should be created successfully")
	public void the_lead_should_be_created_successfully() throws InterruptedException {
		 String leadName = leadsPage.captureTheLeadName();
		 Assert.assertTrue(leadsPage.captureTheLeadName().contains(leadName));
		 Thread.sleep(5000);
	}

}
