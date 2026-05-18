package com.stepdefinitions;

import org.testng.Assert;

import com.actions.SearchActions;
import com.actions.WishlistAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStepDefinition {

    WishlistAction wishlistAction=new WishlistAction(HelperClass.getDriver());

    @And("user clicks on the searched product")
    public void user_clicks_on_the_searched_product() {
        wishlistAction.openSearchedProduct(SearchStepDefinition.searchedProduct);
    }

    @And("clicks on Add to wishlist button")
    public void clicks_on_add_to_wishlist_button() {
        wishlistAction.clickAddToWishlist();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage=wishlistAction.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Then("searched product should be added to the wishlist")
    public void searched_product_should_be_added_to_the_wishlist() {

        wishlistAction.clickWishlistLink();

        String actualProduct=wishlistAction.getWishlistProductName();
        Assert.assertEquals(actualProduct,SearchStepDefinition.searchedProduct);
    }

    @When("user adds a product to wishlist")
    public void user_adds_a_product_to_wishlist() {
        wishlistAction.openSearchedProduct(SearchStepDefinition.searchedProduct);
        wishlistAction.clickAddToWishlist();
    }

    @And("user removes the product from wishlist")
    public void user_removes_the_product_from_wishlist() {
        wishlistAction.clickWishlistLink();
        wishlistAction.removeProductFromWishlist();
    }

    @Then("wishlist should be empty")
    public void wishlist_should_be_empty() {
        String actualMessage=wishlistAction.getEmptyWishlistMessage();
        Assert.assertTrue(actualMessage.contains("The wishlist is empty"));
    }

    @And("user moves wishlist product to cart")
    public void user_moves_wishlist_product_to_cart() {
        wishlistAction.clickWishlistLink();
        wishlistAction.selectProductForAddToCart();
        wishlistAction.clickAddToCartButton();
    }

    @Then("product should be added to shopping cart")
    public void product_should_be_added_to_shopping_cart() {
    	
        wishlistAction.openShoppingCart();
        String actualProduct=wishlistAction.getCartProductName();
        Assert.assertEquals(actualProduct,SearchStepDefinition.searchedProduct);
    }

    @And("user navigates to wishlist page")
    public void user_navigates_to_wishlist_page() {
        wishlistAction.clickWishlistLink();
    }

    @Then("product should be displayed in wishlist")
    public void product_should_be_displayed_in_wishlist() {

        String actualProduct=wishlistAction.getWishlistProductName();
        Assert.assertEquals(actualProduct,SearchStepDefinition.searchedProduct);
    }
    
    @When("user searches and adds product {string} to wishlist")
    public void user_searches_and_adds_product_to_wishlist(String product) {

        SearchStepDefinition.searchedProduct = product;

        SearchActions searchActions=new SearchActions(HelperClass.getDriver());
		searchActions.searchProduct(product);
        searchActions.clickSearch();

        wishlistAction.openSearchedProduct(product);
        wishlistAction.clickAddToWishlist();
    }
}