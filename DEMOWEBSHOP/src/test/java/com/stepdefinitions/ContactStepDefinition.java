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

    // Existing step - DO NOT CHANGE
    @When("the user clicks the Contact us link")
    public void the_user_clicks_the_contact_us_link() {
        contact.waitforContactLink();
        contact.clickContact();
    }

    // Existing step - DO NOT CHANGE
    @Then("the user should see auto-filled Name and Email fields")
    public void the_user_should_see_auto_filled_name_and_email_fields() {

        String actualName = contact.getNameValue();
        String actualEmail = contact.getEmailValue();

        log.info(actualName);
        log.info(actualEmail);

        Assert.assertFalse(actualName.isEmpty());
        Assert.assertFalse(actualEmail.isEmpty());
    }

    // Existing step - DO NOT CHANGE
    @Then("the user should see empty Name and Email fields")
    public void the_user_should_see_empty_name_and_email_fields() {

        String actualName = contact.getNameValue();
        String actualEmail = contact.getEmailValue();

        log.info(actualName);
        log.info(actualEmail);

        Assert.assertTrue(actualName.isEmpty());
        Assert.assertTrue(actualEmail.isEmpty());
    }

    // New step - Scenario 3
    @When("the user enters enquiry details")
    public void the_user_enters_enquiry_details() {

        contact.enterEnquiryDetails(
                "I am interested in knowing more about your products."
        );
    }

    // New step - Scenario 3
    @Then("the user should see an appropriate successful message")
    public void the_user_should_see_an_appropriate_successful_message() {

        String actualMessage = contact.getSuccessMessage();

        log.info("Success message: " + actualMessage);

        Assert.assertFalse(actualMessage.isEmpty());
    }

    // New step - Scenario 4
    @When("the user clicks the \"Submit\" button without entering details")
    public void the_user_clicks_the_submit_button_without_entering_details() {

        contact.clickSubmit();
    }

    // New step - Scenario 4
    @Then("the user should see an appropriate validation error message")
    public void the_user_should_see_an_appropriate_validation_error_message() {

        String actualError = contact.getValidationError();

        log.info("Validation error message: " + actualError);

        Assert.assertFalse(actualError.isEmpty());
    }
}