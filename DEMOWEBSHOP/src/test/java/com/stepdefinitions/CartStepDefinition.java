package com.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition {

	private static final Logger logger = LogManager.getLogger(CartStepDefinition.class);
	CartAction cartAction;

	@Given("User is on Demo Web Shop Website")
	public void user_is_on_demo_web_shop_website() {

		logger.info("Launching Demo Web Shop");
		HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
		cartAction = new CartAction(HelperClass.getDriver());
	}

	@Given("User is on product details page")
	public void user_is_on_product_details_page() {

		logger.info("Navigating to product details page");
		cartAction.openBookPage();
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {

		logger.info("Clicking Add To Cart");
		cartAction.addCart();
	}

	@Then("Product should be added to shopping cart")
	public void product_should_be_added_to_shopping_cart() {

		logger.info("Verifying product added to cart");
		Assert.assertTrue(cartAction.checkCart());
	}

	@When("User adds multiple products to cart")
	public void user_adds_multiple_products_to_cart(DataTable dataTable) {

		logger.info("Adding multiple products");
		cartAction.addManyProducts(dataTable);
	}

	@Then("All products should be added to shopping cart")
	public void all_products_should_be_added_to_shopping_cart() {

		logger.info("Verifying multiple products added");
		Assert.assertTrue(cartAction.checkCart());
	}

	@Given("User added multiple products to shopping cart")
	public void user_added_multiple_products_to_shopping_cart() {

		logger.info("Adding multiple products before cart validation");
		user_is_on_product_details_page();
		user_clicks_on_add_to_cart_button();
	}

	@Given("User navigates to shopping cart page")
	public void user_navigates_to_shopping_cart_page() {

		logger.info("Opening shopping cart");
		cartAction.openCart();
	}

	@Then("Added products should be displayed in shopping cart")
	public void added_products_should_be_displayed_in_shopping_cart() {

		logger.info("Checking products inside cart");
		Assert.assertTrue(cartAction.checkProducts());
	}

	@Then("Cart subtotal and total amount should be displayed correctly")
	public void cart_subtotal_and_total_amount_should_be_displayed_correctly() {

		logger.info("Checking subtotal");
		Assert.assertTrue(cartAction.checkTotal());
	}

	@Given("User navigates to shopping cart page without adding any product")
	public void user_navigates_to_shopping_cart_page_without_adding_any_product() {

		logger.info("Opening empty cart");
		cartAction.openEmptyCart();
	}

	@Then("User should see message as {string}")
	public void user_should_see_message_as(String expectedMessage) {

		logger.info("Verifying empty cart message");
		String actualMessage = cartAction.getEmptyMsg();
		assertEquals(actualMessage, expectedMessage);
	}

	@Given("User added product to shopping cart")
	public void user_added_product_to_shopping_cart() {

		logger.info("Adding single product to cart");
		cartAction.addOneProduct();
	}

	@When("User enters invalid coupon code {string}")
	public void user_enters_invalid_coupon_code(String coupon) {

		logger.info("Entering invalid coupon code");
		cartAction.enterCoupon(coupon);
	}

	@When("User clicks on Apply Coupon button")
	public void user_clicks_on_apply_coupon_button() {

		logger.info("Applying coupon");
		cartAction.clickCoupon();
	}

	@Then("User should see the invalid message {string}")
	public void user_should_see_the_invalid_message(String expectedMessage) {

		logger.info("Verifying invalid message");
		String actualMessage = cartAction.getMsg();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@When("User enters invalid gift card code {string}")
	public void user_enters_invalid_gift_card_code(String giftcard) {

		logger.info("Entering invalid gift card");
		cartAction.enterGift(giftcard);
	}

	@When("User clicks on Apply Gift Card button")
	public void user_clicks_on_apply_gift_card_button() {

		logger.info("Applying gift card");
		cartAction.clickGift();
	}

	@When("User updates product quantity")
	public void user_updates_product_quantity() {

		logger.info("Updating quantity");
		cartAction.updateQuantity("2");
	}

	@When("User clicks on Update Shopping Cart button")
	public void user_clicks_on_update_shopping_cart_button() {

		logger.info("Updating shopping cart");
		cartAction.clickUpdateCart();
	}

	@Then("Updated quantity should be displayed in shopping cart")
	public void updated_quantity_should_be_displayed_in_shopping_cart() {

		logger.info("Checking updated quantity");
		Assert.assertTrue(cartAction.checkUpdatedQty("2"));
	}

	@When("User removes product from shopping cart")
	public void user_removes_product_from_shopping_cart() {

		logger.info("Removing product");
		cartAction.removeProduct();
	}

	@Then("Product should be removed from shopping cart")
	public void product_should_be_removed_from_shopping_cart() {

		logger.info("Checking removed product");
		Assert.assertTrue(cartAction.checkRemovedProduct());
	}
}