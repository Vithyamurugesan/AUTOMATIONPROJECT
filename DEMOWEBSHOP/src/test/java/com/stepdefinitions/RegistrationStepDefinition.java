package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.RegistrationActions;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition {

    private static final Logger log = LogManager.getLogger(RegistrationStepDefinition.class);

    RegistrationActions registrationActions;

    @Given("the user is on the DemoWebShop homepage")
    public void the_user_is_on_the_demo_web_shop_homepage() {
    	HelperClass.getDriver().get(ConfigReader.get("app.url"));
        registrationActions = new RegistrationActions(HelperClass.getDriver());
    }

    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String string) {
        registrationActions.clickRegisterLink();
    }

    @When("the user fills in the mandatory registration details")
    public void the_user_fills_in_the_mandatory_registration_details(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName       = data.get(0).get("Value");
        String lastName        = data.get(1).get("Value");
        String email           = data.get(2).get("Value");
        String password        = data.get(3).get("Value");
        String confirmPassword = data.get(4).get("Value");

        registrationActions.enterFirstName(firstName);
        registrationActions.enterLastName(lastName);
        registrationActions.enterEmail(email);
        registrationActions.enterPassword(password);
        registrationActions.enterConfirmPassword(confirmPassword);
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        if (string.equalsIgnoreCase("Register")) {
            registrationActions.clickRegisterButton();
        } else if (string.equalsIgnoreCase("Continue")) {
            registrationActions.clickContinueButton();
        }
    }

    @Then("the user should be redirected to the registration confirmation page")
    public void the_user_should_be_redirected_to_the_registration_confirmation_page() {
        String currentUrl = HelperClass.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("registerresult"),
                "Expected registration result page but was: " + currentUrl);
    }

    @Then("the page should display the message {string}")
    public void the_page_should_display_the_message(String string) {
        String actualMessage = registrationActions.getSuccessMessage();
        Assert.assertEquals(actualMessage, string, "Success message mismatch");
    }

    @Then("the first name error message {string} should be displayed")
    public void the_first_name_error_message_should_be_displayed(String string) {
        String actualError = registrationActions.getFirstNameErrorMessage();
        Assert.assertEquals(actualError, string, "First name error mismatch");
    }

    @And("the last name error message {string} should be displayed")
    public void the_last_name_error_message_should_be_displayed(String string) {
        String actualError = registrationActions.getLastNameErrorMessage();
        Assert.assertEquals(actualError, string, "Last name error mismatch");
    }

    @And("the email error message {string} should be displayed")
    public void the_email_error_message_should_be_displayed(String string) {
        String actualError = registrationActions.getEmailErrorMessage();
        Assert.assertEquals(actualError, string, "Email error mismatch");
    }

    @And("the password error message {string} should be displayed")
    public void the_password_error_message_should_be_displayed(String string) {
        String actualError = registrationActions.getPasswordErrorMessage();
        Assert.assertEquals(actualError, string, "Password error mismatch");
    }

    @Then("the confirm password error message {string} should be displayed")
    public void the_confirm_password_error_message_should_be_displayed(String string) {
        String actualError = registrationActions.getConfirmPasswordErrorMessage();
        Assert.assertEquals(actualError, string, "Confirm password error mismatch");
    }

    @Then("the page should display the error {string}")
    public void the_page_should_display_the_error(String string) {
        String actualError = registrationActions.getExistingEmailErrorMessage();
        Assert.assertTrue(actualError.contains(string),
                "Existing email error mismatch. Actual: " + actualError);
    }
}