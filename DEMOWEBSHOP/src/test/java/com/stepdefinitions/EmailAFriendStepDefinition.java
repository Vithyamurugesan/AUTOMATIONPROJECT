package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.EmailAFriendActions;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailAFriendStepDefinition {

    private static final Logger log = LogManager.getLogger(EmailAFriendStepDefinition.class);

    EmailAFriendActions emailAFriendActions;

    @Given("user is logged in and on the laptop product page")
    public void user_is_logged_in_and_on_the_laptop_product_page() {
        emailAFriendActions = new EmailAFriendActions(HelperClass.getDriver());
        HelperClass.getDriver().get(ConfigReader.get("app.url") + ConfigReader.get("laptop.url"));
        log.info("User navigated to 14.1-inch Laptop product page");
    }

    @When("user clicks on Email a friend button")
    public void user_clicks_on_email_a_friend_button() {
        emailAFriendActions.clickEmailAFriendButton();
    }

    @Then("user should be on the Email a friend page")
    public void user_should_be_on_the_email_a_friend_page() {
        log.info("Verifying Email a friend page is displayed");
        Assert.assertTrue(emailAFriendActions.isEmailAFriendPageDisplayed(),
                "User should be on the Email a friend page");
    }

    @And("user enters friend email {string} and personal message {string}")
    public void user_enters_friend_email_and_personal_message(String email, String message) {
        log.info("Entering friend email: {} and personal message", email);
        emailAFriendActions.enterFriendEmail(email);
        emailAFriendActions.enterYourEmail();
        emailAFriendActions.enterPersonalMessage(message);
    }

    @And("user clicks Send email button")
    public void user_clicks_send_email_button() {
        emailAFriendActions.clickSendEmail();
    }

    @Then("{string} should be displayed")
    public void result_should_be_displayed(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("success")) {
            log.info("Verifying success message is displayed after sending email");
            Assert.assertTrue(emailAFriendActions.isSuccessMessageDisplayed(),
                    "Success message should be shown after sending email to friend");
        } else if (expectedResult.equalsIgnoreCase("error")) {
            log.info("Verifying validation error is displayed for empty friend email");
            Assert.assertTrue(emailAFriendActions.isValidationErrorDisplayed(),
                    "Validation error should appear when friend email field is empty");
        }
    }
}