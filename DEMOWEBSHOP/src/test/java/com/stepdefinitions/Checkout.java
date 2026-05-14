package com.stepdefinitions;

import org.testng.Assert;

import com.pages.CheckoutPage;
import com.utilities.helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout {

    CheckoutPage cp ;

    @Given("User is on shopping cart page")
    public void user_is_on_shopping_cart_page() {
    	
    	cp = new CheckoutPage(helper.getdriver());
        helper.getdriver().get("https://demowebshop.tricentis.com/");
        cp.addProductToCart();
        cp.openCartPage();  // Navigate to cart page
    }

    @When("User clicks checkout without selecting terms checkbox")
    public void user_clicks_checkout_without_selecting_terms_checkbox() {
        cp.clickCheckoutButton();
    }

    @Then("Warning message should be displayed")
    public void warning_message_should_be_displayed() {

        String actualMessage = cp.getWarningMessage();
        Assert.assertTrue(
                actualMessage.contains(
                        "Please accept the terms of service before the next step."),
                "Warning message not displayed");
    }

    @When("User selects terms and conditions checkbox")
    public void user_selects_terms_and_conditions_checkbox() {
        cp.selectTermsCheckbox();
    }

    @When("User clicks checkout button")
    public void user_clicks_checkout_button() {
        cp.clickCheckoutButton();
    }

    @Then("User should navigate to checkout page")
    public void user_should_navigate_to_checkout_page() {
        String currentURL = cp.getCurrentURL();
        Assert.assertTrue( currentURL.contains("login"), "User is not redirected correctly");
    }
}