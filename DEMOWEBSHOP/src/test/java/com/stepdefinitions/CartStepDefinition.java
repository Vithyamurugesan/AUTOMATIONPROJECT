package com.stepdefinitions;

import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertEquals;

public class CartStepDefinition {

    CartAction cartAction;

    @Given("User is on Demo Web Shop Website")
    public void user_is_on_demo_web_shop_website() {
        HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
        cartAction =new CartAction(HelperClass.getDriver());
    }

    @Given("User is on product details page")
    public void user_is_on_product_details_page() {
        cartAction.openProductDetailsPage();
    }

    @When("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() {
        cartAction.addProductToCart();
    }

    @Then("Product should be added to shopping cart")
    public void product_should_be_added_to_shopping_cart() {
        Assert.assertTrue(cartAction.verifyShoppingCart());
    }

    @When("User adds multiple products to cart")
    public void user_adds_multiple_products_to_cart(DataTable dataTable) {
        cartAction.addMultipleProducts(dataTable);
    }

    @Then("All products should be added to shopping cart")
    public void all_products_should_be_added_to_shopping_cart() {
        Assert.assertTrue(cartAction.verifyShoppingCart());
    }
    
    @Given("User added multiple products to shopping cart")
    public void user_added_multiple_products_to_shopping_cart() {
        user_is_on_product_details_page();
        user_clicks_on_add_to_cart_button();
    }

    @Given("User navigates to shopping cart page")
    public void user_navigates_to_shopping_cart_page() {
        cartAction.openShoppingCart();
    }

    @Then("Added products should be displayed in shopping cart")
    public void added_products_should_be_displayed_in_shopping_cart() {
        Assert.assertTrue(cartAction.verifyProductsAdded());
    }

    @Then("Cart subtotal and total amount should be displayed correctly")
    public void cart_subtotal_and_total_amount_should_be_displayed_correctly() {
        Assert.assertTrue(cartAction.verifyTotalAmount());
    }

    @Given("User navigates to shopping cart page without adding any product")
    public void user_navigates_to_shopping_cart_page_without_adding_any_product() {
        cartAction.openEmptyCartPage();
    }

    @Then("User should see message as {string}")
    public void user_should_see_message_as(String expectedMessage) {
        String actualMessage = cartAction.getEmptyCartMessage();
        assertEquals(actualMessage, expectedMessage);
    }

    @Given("User added product to shopping cart")
    public void user_added_product_to_shopping_cart() {
        cartAction.addSingleProduct();
    }

    @When("User enters invalid coupon code {string}")
    public void user_enters_invalid_coupon_code(String coupon) {
        cartAction.enterCouponCode(coupon);
    }

    @When("User clicks on Apply Coupon button")
    public void user_clicks_on_apply_coupon_button() {
        cartAction.clickApplyCoupon();
    }

    @Then("User should see the invalid message {string}")
    public void user_should_see_the_invalid_message(String expectedMessage) {
        String actualMessage = cartAction.getValidationMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @When("User enters invalid gift card code {string}")
    public void user_enters_invalid_gift_card_code(String giftcard) {
        cartAction.enterGiftCardCode(giftcard);
    }

    @When("User clicks on Apply Gift Card button")
    public void user_clicks_on_apply_gift_card_button() {
        cartAction.clickApplyGiftCard();
    }
}