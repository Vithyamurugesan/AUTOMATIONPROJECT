package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.SearchActions;
import com.actions.WishlistAction;
import com.utilities.HelperClass;
import com.utilities.TestDataReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStepDefinition {

    private static final Logger log=LogManager.getLogger(WishlistStepDefinition.class);

    WishlistAction wishlistAction=new WishlistAction(HelperClass.getDriver());

    SearchActions searchActions=new SearchActions(HelperClass.getDriver());

    String selectedProduct;

    @When("user adds {string} to wishlist")
    public void user_adds_to_wishlist(String product) {

        log.info("Adding product to wishlist : {}", product);

        selectedProduct=product;
        searchActions.searchProduct(product);

        log.debug("Searching product : "+ product);

        searchActions.clickSearch();
        searchActions.openProductFromResults(product);

        wishlistAction.clickAddToWishlist();

        log.info("Product added to wishlist : {}", product);
    }

    @When("user adds product to wishlist")
    public void user_adds_product_to_wishlist() {

        selectedProduct=TestDataReader.get("wishlist.product");

        log.info("Adding product from test data : "+ selectedProduct);

        searchActions.searchProduct(selectedProduct);
        searchActions.clickSearch();
        searchActions.openProductFromResults(selectedProduct);

        wishlistAction.clickAddToWishlist();

        log.info("Product added successfully");
    }

    @Then("success message {string} should be displayed")
    public void success_message_should_be_displayed(
            String expectedMessage) {

        String actualMessage = wishlistAction.getSuccessMessage();

        log.debug("Actual success message : "+ actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));

        log.info("Success message validation passed");
    }

    @Then("product should be added to wishlist")
    public void product_should_be_added_to_wishlist() {

        wishlistAction.clickWishlistLink();

        String actual = wishlistAction.getWishlistProductName();

        log.debug("Wishlist product : "+ actual);

        Assert.assertEquals(actual, selectedProduct);

        log.info("Wishlist validation passed for : "+selectedProduct);
    }

    @When("user removes product from wishlist")
    public void user_removes_product_from_wishlist() {

        log.info("Removing product from wishlist");

        wishlistAction.clickWishlistLink();
        wishlistAction.removeProductFromWishlist();

        log.info("Product removed from wishlist");
    }

    @Then("wishlist message {string} should be displayed")
    public void wishlist_message_should_be_displayed(String expectedMessage) {

        String actualMessage=wishlistAction.getEmptyWishlistMessage();

        log.debug("Wishlist message : {}", actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage);

        log.info("Wishlist empty validation passed");
    }

    @And("product should be added to cart")
    public void product_should_be_added_to_cart() {

        log.info("Moving product to cart : "+selectedProduct);

        wishlistAction.clickWishlistLink();
        wishlistAction.selectProductForAddToCart();
        wishlistAction.clickAddToCartButton();

        wishlistAction.openShoppingCart();

        String actual = wishlistAction.getCartProductName();

        log.debug("Cart product : "+ actual);

        Assert.assertEquals(actual,selectedProduct);

        log.info("Cart validation passed for : "+selectedProduct);
    }

    @When("user navigates to wishlist page")
    public void user_navigates_to_wishlist_page() {
        log.info("Navigating to wishlist page");
        wishlistAction.clickWishlistLink();
    }

    @Then("product should be displayed in wishlist")
    public void product_should_be_displayed_in_wishlist() {

        String actual = wishlistAction.getWishlistProductName();
        
        log.debug("Displayed wishlist product : "+actual);

        Assert.assertEquals(actual, selectedProduct);

        log.info("Wishlist display validation passed");
    }
}