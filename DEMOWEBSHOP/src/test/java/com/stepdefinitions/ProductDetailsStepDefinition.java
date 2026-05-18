package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import com.actions.ProductDetailsAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsStepDefinition {

	private static final Logger logger = LogManager.getLogger(ProductDetailsStepDefinition.class);

	ProductDetailsAction productDetailsAction;

	@Given("User launches Demo Web Shop application")
	public void launch_app() {

		logger.info("Launching Demo Web Shop application");

		HelperClass.getDriver().get("https://demowebshop.tricentis.com/");

		productDetailsAction = new ProductDetailsAction(HelperClass.getDriver());
	}

	@When("User clicks category {string}")
	public void click_category(String category) {

		logger.info("Opening category: " + category);

		productDetailsAction.openCategory(category);
	}

	@When("User selects product {string}")
	public void select_product(String product) {

		logger.info("Selecting product: " + product);

		productDetailsAction.selectProduct(product);
	}

	@Then("Product details page should be opened")
	public void product_page() {

		logger.info("Checking product details page");

		Assert.assertTrue(productDetailsAction.checkProductPage());
	}

	@Then("Product name should be displayed as {string}")
	public void name(String name) {

		logger.info("Checking product name: " + name);

		Assert.assertTrue(productDetailsAction.checkProductName());
	}

	@Then("Product price should be displayed")
	public void price() {

		logger.info("Checking product price");

		Assert.assertTrue(productDetailsAction.checkProductPrice());
	}

	@Then("Product description should be displayed")
	public void desc() {

		logger.info("Checking product description");

		Assert.assertTrue(productDetailsAction.checkProductDescription());
	}

	@Then("Product image should be displayed")
	public void image() {

		logger.info("Checking product image");

		Assert.assertTrue(productDetailsAction.checkProductImage());
	}

	@Then("Product availability should be displayed as {string}")
	public void availability(String expectedValue) {

		logger.info("Checking product availability");

		String actualLabel = productDetailsAction.getAvailabilityLabel();

		String actualValue = productDetailsAction.getAvailabilityValue();

		Assert.assertEquals(actualLabel, "Availability:");

		Assert.assertEquals(actualValue, expectedValue);
	}

	@When("User enters quantity {string}")
	public void qty(String qty) {

		logger.info("Entering quantity: " + qty);

		productDetailsAction.enterQuantity(qty);
	}

	@When("User clicks add to cart button")
	public void add() {

		logger.info("Clicking add to cart button");

		productDetailsAction.clickAddToCart();
	}

	@Then("User should see validation message {string}")
	public void validate(String expectedMessage) {

		logger.info("Checking validation message");

		String actualMessage = productDetailsAction.getNotificationMessage();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
}