package com.stepdefinitions;

import com.actions.RegisterAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterStepDefinition {

    private RegisterAction registerAction;

    private RegisterAction action() {
        if (registerAction == null) {
            registerAction = new RegisterAction(HelperClass.getDriver());
        }
        return registerAction;
    }

    @Given("User is on Demo Web Shop application")
    public void user_is_on_demo_web_shop_application() {

        HelperClass.getDriver().get(ConfigReader.get("app.url"));

        new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.titleContains("Demo Web Shop"));

        System.out.println("Application loaded. Page title: "
                + HelperClass.getDriver().getTitle());
    }

    @Given("User navigates to the Register page")
    public void user_navigates_to_register_page() {
        action().navigateToRegisterPage();
    }

    @When("User enters valid registration details")
    public void user_enters_valid_registration_details() {
        action().enterValidRegistrationDetailsFromConfig();
    }

    @When("User clicks on Register button")
    public void user_clicks_on_register_button() {
        action().clickRegisterButton();
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        String actualMessage = action().getSuccessMessage();

        Assert.assertFalse(actualMessage.isEmpty(),
                "FAIL: Registration success message is empty.");
        Assert.assertTrue(
                actualMessage.toLowerCase().contains(expectedMessage.toLowerCase()),
                "FAIL: Expected message to contain [" + expectedMessage
                        + "] but got [" + actualMessage + "]");

        System.out.println("Success message verified: " + actualMessage);
    }

    @Then("User should see Continue button")
    public void user_should_see_continue_button() {
        Assert.assertTrue(action().isContinueButtonDisplayed(),
                "FAIL: Continue button is NOT displayed after registration.");

        System.out.println("Continue button is displayed successfully.");
    }
}