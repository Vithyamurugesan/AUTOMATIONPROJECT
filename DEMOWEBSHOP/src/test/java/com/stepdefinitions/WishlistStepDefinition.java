package com.stepdefinitions;

import org.testng.Assert;

import com.actions.WishlistAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStepDefinition {

    WishlistAction wishlistAction=new WishlistAction(HelperClass.getDriver());

    @When("user navigates to a product page")
    public void user_navigates_to_a_product_page() {
        wishlistAction.navigateToProductPage();
    }

    @And("clicks on Add to wishlist button")
    public void clicks_on_add_to_wishlist_button() {
        wishlistAction.clickAddToWishlist();
    }

    @Then("success message should be displayed")
    public void success_message_should_be_displayed() {
        String actualMessage=wishlistAction.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains("The product has been added to your wishlist"));
    }

    @Then("product should be added to the wishlist")
    public void product_should_be_added_to_the_wishlist() {
        wishlistAction.clickWishlistLink();
        String actualProduct=wishlistAction.getWishlistProductName();
        Assert.assertEquals(actualProduct,"Build your own cheap computer");
    }

    @When("user adds a product to wishlist")
    public void user_adds_a_product_to_wishlist() {
        wishlistAction.navigateToProductPage();
        wishlistAction.clickAddToWishlist();
    }

    @And("user navigates to wishlist page")
    public void user_navigates_to_wishlist_page() {
        wishlistAction.clickWishlistLink();
    }

    @Then("added product should be displayed in the wishlist")
    public void added_product_should_be_displayed_in_the_wishlist() {
        String actualProduct=wishlistAction.getWishlistProductName();
        Assert.assertEquals(actualProduct,"Build your own cheap computer");
    }

    @And("user removes the product from wishlist")
    public void user_removes_the_product_from_wishlist() {
        wishlistAction.removeProductFromWishlist();
    }

    @Then("wishlist should display empty message")
    public void wishlist_should_display_empty_message() {
        String actualMessage=wishlistAction.getEmptyWishlistMessage();
        Assert.assertTrue(actualMessage.contains("The wishlist is empty"));
    }

    @And("user selects the product for adding to cart")
    public void user_selects_the_product_for_adding_to_cart() {
        wishlistAction.selectProductForAddToCart();
    }

    @And("clicks on Add to cart button")
    public void clicks_on_add_to_cart_button() {
        wishlistAction.clickAddToCartButton();
    }

    @Then("product should be added to the shopping cart")
    public void product_should_be_added_to_the_shopping_cart() {
        wishlistAction.openShoppingCart();
        String actualProduct=wishlistAction.getCartProductName();
        Assert.assertEquals(actualProduct,"Build your own cheap computer");
    }
}