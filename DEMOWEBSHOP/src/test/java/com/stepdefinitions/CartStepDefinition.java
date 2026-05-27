package com.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition {

	private static final Logger logger = LogManager.getLogger(CartStepDefinition.class);

	CartAction cartAction;

	@Given("User is on Demo Web Shop Website")
	public void user_is_on_demo_web_shop_website() {

		logger.info("Launching Demo Web Shop");

		HelperClass.getDriver().get(ConfigReader.get("app.url"));

		cartAction = new CartAction(HelperClass.getDriver());
	}
	
	@Given("User clicks on Books category")
	public void user_clicks_on_books_category() {

		logger.info("Clicking Books category");

		cartAction.openBookPage();
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {

		logger.info("Clicking Add To Cart button");

		cartAction.addCart();
	}

	@Then("User should be product added to shopping cart")
	public void user_should_be_product_added_to_shopping_cart() {

		logger.info("Checking product added to cart");

		Assert.assertTrue(cartAction.checkCart());
	}

	@Given("User adds multiple products from test data")
	public void user_adds_multiple_products_from_test_data() {

		logger.info("Adding products from excel");

		String path = ConfigReader.get("cart.excel.path");

		cartAction.addProductsFromExcel(path,ConfigReader.get("cart.sheet.name"));
	}

	@When("User clicks on Shopping Cart")
	public void user_clicks_on_shopping_cart() {

		logger.info("Opening shopping cart");

		cartAction.openShoppingCart();
	}

	@Then("User should see added products should be displayed in shopping cart")
	public void user_should_see_added_products_should_be_displayed_in_shopping_cart() {

		logger.info("Checking products in shopping cart");

		Assert.assertTrue(cartAction.verifyProductsDisplayed());
	}

	@Given("User added multiple products to shopping cart")
	public void user_added_multiple_products_to_shopping_cart() {

		logger.info("Adding multiple products");

		String path = ConfigReader.get("cart.excel.path");

		cartAction.addProductsFromExcel(path, ConfigReader.get("cart.sheet.name"));
	}

	@Then("Added products should be displayed in shopping cart")
	public void added_products_should_be_displayed_in_shopping_cart() {

		logger.info("Checking added products");

		Assert.assertTrue(cartAction.verifyProductsDisplayed());
	}

	@Then("User should see cart subtotal and total amount")
	public void user_should_see_cart_subtotal_and_total_amount() {

		logger.info("Checking subtotal and total");

		Assert.assertTrue(cartAction.verifyTotalAmount());
	}

	@Given("User clicks on Shopping Cart without adding product")
	public void user_clicks_on_shopping_cart_without_adding_product() {

		logger.info("Opening empty shopping cart");

		cartAction.openEmptyCart();
	}

	@Then("User should see message as Your Shopping Cart is empty!")
	public void user_should_see_message_as_your_shopping_cart_is_empty() {

		logger.info("Checking empty cart message");

		String actualMessage = cartAction.getEmptyCartMessage();

		assertEquals(actualMessage,ConfigReader.get("empty.cart.message"));
	}

	@When("User enters invalid coupon code {string}")
	public void user_enters_invalid_coupon_code(String coupon) {

		logger.info("Entering invalid coupon");

		cartAction.enterCouponCode(coupon);
	}

	@When("User clicks on Apply Coupon button")
	public void user_clicks_on_apply_coupon_button() {

		logger.info("Clicking Apply Coupon");

		cartAction.clickApplyCoupon();
	}

	@Then("User should see the invalid message as The coupon code you entered couldn't be applied to your order")
	public void user_should_see_the_invalid_message_as_the_coupon_code_you_entered_couldn_t_be_applied_to_your_order() {

		logger.info("Checking invalid message");

		Assert.assertTrue(cartAction.getValidationMessage().contains(ConfigReader.get("invalid.coupon.message")));
	}

	@When("User enters invalid gift card code {string}")
	public void user_enters_invalid_gift_card_code(String giftcard) {

		logger.info("Entering invalid gift card");

		cartAction.enterGiftCardCode(giftcard);
	}

	@When("User clicks on Apply Gift Card button")
	public void user_clicks_on_apply_gift_card_button() {

		logger.info("Clicking Apply Gift Card");

		cartAction.clickApplyGiftCard();
	}

	@When("User updates product quantity")
	public void user_updates_product_quantity() {

		logger.info("Updating quantity");

		cartAction.updateQuantity(ConfigReader.get("updated.quantity"));
	}

	@When("User clicks on Update Shopping Cart button")
	public void user_clicks_on_update_shopping_cart_button() {

		logger.info("Clicking Update Shopping Cart");

		cartAction.clickUpdateShoppingCart();
	}

	@Then("User should see the update quantity in shopping cart")
	public void user_should_see_the_update_quantity_in_shopping_cart() {

		logger.info("Checking updated quantity");

		Assert.assertTrue(cartAction.verifyUpdatedQuantity(ConfigReader.get("updated.quantity")));
	}

	@When("User removes product from shopping cart")
	public void user_removes_product_from_shopping_cart() {

		logger.info("Removing product");

		cartAction.removeProduct();
	}

	@Then("User should see product removed from shopping cart")
	public void user_should_see_product_removed_from_shopping_cart() {

		logger.info("Checking removed product");

		Assert.assertTrue(cartAction.verifyRemovedProduct());
	}
}