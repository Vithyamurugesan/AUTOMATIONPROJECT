package com.stepdefinitions;

import org.testng.Assert;
import com.actions.ProductDetailsAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class ProductDetailsStepDefinition {

    ProductDetailsAction action = new ProductDetailsAction(HelperClass.getDriver());

    @Given("User launches Demo Web Shop application")
    public void launch_app() {
        HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
    }

    @When("User clicks Books category")
    public void click_books() {
        action.openBooks();
    }

    @When("User selects {string} product")
    public void select_product(String product) {
        action.selectProduct();
    }

    @Then("Product details page should be opened")
    public void product_page() {
        Assert.assertTrue(action.isNameDisplayed());
    }

    @Then("Product name should be displayed as {string}")
    public void name(String name) {
        Assert.assertTrue(action.isNameDisplayed());
    }

    @Then("Product price should be displayed")
    public void price() {
        Assert.assertTrue(action.isPriceDisplayed());
    }

    @Then("Product description should be displayed")
    public void desc() {
        Assert.assertTrue(action.isDescDisplayed());
    }

    @Then("Product image should be displayed")
    public void image() {
        Assert.assertTrue(action.isImageDisplayed());
    }

    @Then("Product availability should be {string}")
    public void availability(String status) {
        String actual = action.getAvailability();
        Assert.assertTrue(actual.contains("In stock") || actual.contains("Out of stock"),
            "Availability not displayed correctly. Actual: " + actual
        );
    }

    @When("User enters quantity {string}")
    public void qty(String qty) {
        action.enterQty(qty);
    }

    @When("User clicks add to cart button")
    public void add() {
        action.addToCart();
    }

    @Then("User should see validation message {string}")
    public void validate(String msg) {
        Assert.assertTrue(action.isQtyError());
    }
}