package com.stepdefinitions;

import org.testng.Assert;

import com.actions.CartAction;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

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
}