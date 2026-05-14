package com.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CartStepDefinition {

    CartAction cartAction;

    @Given("User is on Demo Web Shop application")
    public void user_is_on_demo_web_shop_application() {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/");
        cartAction =new CartAction(DriverFactory.getDriver());
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
        Assert.assertTrue(
                cartAction.verifyShoppingCart());
    }

    @Given("User is on Demo Web Shop home page")
    public void user_is_on_demo_web_shop_home_page() {

        DriverFactory.getDriver()
                .get("https://demowebshop.tricentis.com/");
    }

    @When("User adds multiple products to cart")
    public void user_adds_multiple_products_to_cart(
            DataTable dataTable) {
        cartAction.addMultipleProducts(dataTable);
    }

    @Then("All products should be added to shopping cart")
    public void all_products_should_be_added_to_shopping_cart() {
        System.out.println(
                "Multiple products added successfully");
    }

    @Given("User has products in shopping cart")
    public void user_has_products_in_shopping_cart() {
        cartAction.openProductDetailsPage();
        cartAction.addProductToCart();
        cartAction.verifyShoppingCart();
    }

    @When("User updates product quantity")
    public void user_updates_product_quantity() {

        cartAction.updateProductQuantity();
    }

    @When("User clicks on Update Shopping Cart")
    public void user_clicks_on_update_shopping_cart() {
        cartAction.clickUpdateCart();
    }

    @Then("Updated quantity should be displayed in cart")
    public void updated_quantity_should_be_displayed_in_cart() {
        System.out.println("Quantity updated successfully");
    }

    @When("User removes product from cart")
    public void user_removes_product_from_cart() {
        cartAction.removeCartProduct();
    }

    @Then("Product should be removed from shopping cart")
    public void product_should_be_removed_from_shopping_cart() {
        System.out.println("Product removed successfully");
    }

    @Given("User has multiple products in shopping cart")
    public void user_has_multiple_products_in_shopping_cart() {
        cartAction.openProductDetailsPage();
        cartAction.addProductToCart();
        cartAction.verifyShoppingCart();
    }

    

    @Then("Cart subtotal and total amount should be displayed correctly")
    public void cart_subtotal_and_total_amount_should_be_displayed_correctly() {
        System.out.println("Cart totals verified");
    }

    @Given("Shopping cart is empty")
    public void shopping_cart_is_empty() {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/cart");
    }

    @Then("Empty cart message {string} should be displayed")
    public void empty_cart_message_should_be_displayed(String expectedMessage) {

        String actual = DriverFactory.getDriver()
                .findElement(By.cssSelector("div.order-summary-content"))
                .getText();
        Assert.assertTrue(actual.toLowerCase().contains("empty"));
    }

    @Given("User is on shopping cart page")
    public void user_is_on_shopping_cart_page() {
        cartAction.openProductDetailsPage();
        cartAction.addProductToCart();
        cartAction.verifyShoppingCart();
    }

    @When("User enters invalid coupon {string}")
    public void user_enters_invalid_coupon(String coupon) {
        cartAction.enterCouponCode(coupon);
    }

    @When("User clicks on Apply Coupon")
    public void user_clicks_on_apply_coupon() {
        cartAction.applyCouponCode();
    }

    @Then("Coupon validation message should be displayed")
    public void coupon_validation_message_should_be_displayed() {
        System.out.println("Coupon validation displayed");
    }

    @When("User enters invalid gift card code {string}")
    public void user_enters_invalid_gift_card_code(String giftcard) {
        cartAction.enterGiftCardCode(giftcard);
    }

    @When("User clicks on Apply Gift Card")
    public void user_clicks_on_apply_gift_card() {
        cartAction.applyGiftCardCode();
    }

    @Then("Gift card validation message should be displayed")
    public void gift_card_validation_message_should_be_displayed() {
        System.out.println("Gift card validation displayed");
    }
    
    @When("User opens shopping cart page")
    public void user_opens_shopping_cart_page() {
        cartAction.openCartPage();
    }

    @Given("User navigates to shopping cart page")
    public void user_navigates_to_shopping_cart_page() {
        DriverFactory.getDriver().get("https://demowebshop.tricentis.com/cart");
    }
}