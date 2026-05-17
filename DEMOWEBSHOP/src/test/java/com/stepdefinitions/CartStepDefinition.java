package com.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition {

	CartAction cartAction;

	@Given("User is on Demo Web Shop Website")
	public void user_is_on_demo_web_shop_website() {
		HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
		cartAction = new CartAction(HelperClass.getDriver());
	}

	@Given("User is on product details page")
	public void user_is_on_product_details_page() {
		cartAction.openBookPage();
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
		cartAction.addCart();
	}

	@Then("Product should be added to shopping cart")
	public void product_should_be_added_to_shopping_cart() {
		Assert.assertTrue(cartAction.checkCart());
	}

	@When("User adds multiple products to cart")
	public void user_adds_multiple_products_to_cart(DataTable dataTable) {
		cartAction.addManyProducts(dataTable);
	}

	@Then("All products should be added to shopping cart")
	public void all_products_should_be_added_to_shopping_cart() {
		Assert.assertTrue(cartAction.checkCart());
	}

	@Given("User added multiple products to shopping cart")
	public void user_added_multiple_products_to_shopping_cart() {
		user_is_on_product_details_page();
		user_clicks_on_add_to_cart_button();
	}

	@Given("User navigates to shopping cart page")
	public void user_navigates_to_shopping_cart_page() {
		cartAction.openCart();
	}

	@Then("Added products should be displayed in shopping cart")
	public void added_products_should_be_displayed_in_shopping_cart() {
		Assert.assertTrue(cartAction.checkProducts());
	}

	@Then("Cart subtotal and total amount should be displayed correctly")
	public void cart_subtotal_and_total_amount_should_be_displayed_correctly() {
		Assert.assertTrue(cartAction.checkTotal());
	}

	@Given("User navigates to shopping cart page without adding any product")
	public void user_navigates_to_shopping_cart_page_without_adding_any_product() {
		cartAction.openEmptyCart();
	}

	@Then("User should see message as {string}")
	public void user_should_see_message_as(String expectedMessage) {
		String actualMessage = cartAction.getEmptyMsg();
		assertEquals(actualMessage, expectedMessage);
	}

	@Given("User added product to shopping cart")
	public void user_added_product_to_shopping_cart() {
		cartAction.addOneProduct();
	}

	@When("User enters invalid coupon code {string}")
	public void user_enters_invalid_coupon_code(String coupon) {
		cartAction.enterCoupon(coupon);
	}

	@When("User clicks on Apply Coupon button")
	public void user_clicks_on_apply_coupon_button() {
		cartAction.clickCoupon();
	}

	@Then("User should see the invalid message {string}")
	public void user_should_see_the_invalid_message(String expectedMessage) {
		String actualMessage = cartAction.getMsg();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@When("User enters invalid gift card code {string}")
	public void user_enters_invalid_gift_card_code(String giftcard) {
		cartAction.enterGift(giftcard);
	}

	@When("User clicks on Apply Gift Card button")
	public void user_clicks_on_apply_gift_card_button() {
		cartAction.clickGift();
	}
}