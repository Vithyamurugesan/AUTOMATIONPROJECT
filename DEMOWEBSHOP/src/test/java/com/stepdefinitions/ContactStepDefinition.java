package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.actions.ContactAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDefinition {
	WebDriver driver;
	ContactAction contact;
	private static final Logger log = LogManager.getLogger(LoginStepDefinition.class);
	public ContactStepDefinition() {

        driver = HelperClass.getDriver();

        contact = new ContactAction(driver);
    }
	@When("the user clicks the Contact us link")
	public void the_user_clicks_the_contact_us_link() {
		contact.waitforContactLink();
		contact.clickContact();
	}

	@Then("the user should see auto-filled Name and Email fields")
	public void the_user_should_see_auto_filled_name_and_email_fields() {
		String actualName = contact.getNameValue();
        String actualEmail = contact.getEmailValue();
        log.info(actualName);
        log.info(actualEmail);
        Assert.assertFalse(actualName.isEmpty());
        Assert.assertFalse(actualEmail.isEmpty());
	}

	@Then("the user should see empty Name and Email fields")
	public void the_user_should_see_empty_name_and_email_fields() {
		 String actualName = contact.getNameValue();
	        String actualEmail = contact.getEmailValue();
	        log.info(actualName);
	        log.info(actualEmail);
	        Assert.assertTrue(actualName.isEmpty());
	        Assert.assertTrue(actualEmail.isEmpty());
		
	}

}
