package com.stepdefinitions;

import com.actions.RegisterAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterStepDefinition {

    private final RegisterAction registerAction =
            new RegisterAction(HelperClass.getDriver());

    @Given("User is on Demo Web Shop application")
    public void user_is_on_demo_web_shop_application() {
        String title = HelperClass.getDriver().getTitle();
    
        Assert.assertNotNull(title,
                "Page title is null — browser may not have loaded the app.");
        Assert.assertFalse(title.trim().isEmpty(),
                "Page title is empty — browser may not have loaded the app.");
        System.out.println("Application loaded. Page title: " + title);
    }



    @Given("User navigates to the Register page")
    public void user_navigates_to_register_page() {
        registerAction.navigateToRegisterPage();
    }


    @When("User enters valid registration details")
    public void user_enters_valid_registration_details() {
        registerAction.enterValidRegistrationDetailsFromConfig();
    }

    @When("User clicks on Register button")
    public void user_clicks_on_register_button() {
        registerAction.clickRegisterButton();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        Assert.assertTrue(registerAction.isRegistrationSuccessful(),
                "FAIL: Registration was NOT successful — success message is not displayed.");
    }

    @Then("User should see registration confirmation message")
    public void user_should_see_registration_confirmation_message() {
        String actualMsg   = registerAction.getSuccessMessage();
        String expectedMsg = registerAction.getExpectedSuccessMessage(); 

        Assert.assertFalse(actualMsg.isEmpty(),
                "FAIL: Registration confirmation message is empty.");
        Assert.assertTrue(
                actualMsg.toLowerCase().contains(expectedMsg.toLowerCase()),
                "FAIL: Expected confirmation message to contain [" + expectedMsg
                        + "] but got [" + actualMsg + "]");

        System.out.println("Registration confirmation message verified: " + actualMsg);
    }

    @When("User enters registration details with an already registered email")
    public void user_enters_registration_details_with_existing_email() {
        registerAction.enterExistingEmailRegistrationFromConfig();
    }

    @Then("User should see existing email error message")
    public void user_should_see_existing_email_error_message() {
  
        Assert.assertTrue(registerAction.isExistingEmailErrorDisplayed(),
                "FAIL: Existing email error message is NOT displayed on the page.");

        String actualError   = registerAction.getExistingEmailErrorMessage();
        String expectedKeyword = registerAction.getExpectedExistingEmailKeyword();

        Assert.assertFalse(actualError.isEmpty(),
                "FAIL: Existing email error message text is empty.");
        Assert.assertTrue(
                actualError.toLowerCase().contains(expectedKeyword.toLowerCase()),
                "FAIL: Expected error to contain [" + expectedKeyword
                        + "] but got [" + actualError + "]");

        System.out.println("Existing email error message verified: " + actualError);
    }
}