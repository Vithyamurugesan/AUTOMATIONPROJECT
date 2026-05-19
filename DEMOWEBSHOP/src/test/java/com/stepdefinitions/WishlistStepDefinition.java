package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.SearchActions;
import com.actions.WishlistAction;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStepDefinition {

    WishlistAction wishlistAction;

    static final String FILE_PATH="src/test/resources/testdata/wishlistData.xlsx";

    static final String SHEET_NAME="Sheet1";

    // Get data from Excel using scenario name
    public Map<String, String> getScenarioData(String scenario) {

        List<Map<String, String>> data=ExcelReader.getData(FILE_PATH,SHEET_NAME);

        Map<String, String> scenarioData=null;

        for (Map<String, String> row : data) {
            if (row.get("scenario").equalsIgnoreCase(scenario)) {
                scenarioData=row;
                break;
            }
        }

        if (scenarioData==null) {
            throw new RuntimeException("No data found for scenario: "+scenario);
        }

        return scenarioData;
    }

    @When("user searches and adds {string} scenario product from excel to wishlist")
    public void user_searches_and_adds_scenario_product_from_excel_to_wishlist(String scenario) {

        wishlistAction=new WishlistAction(HelperClass.getDriver());

        Map<String, String> rowData=getScenarioData(scenario);
        String product=rowData.get("product");
        SearchStepDefinition.searchedProduct=product;

        SearchActions searchActions=new SearchActions(HelperClass.getDriver());

        searchActions.searchProduct(product);
        searchActions.clickSearch();

        wishlistAction.openSearchedProduct(product);
        wishlistAction.clickAddToWishlist();
    }

    @Then("message for {string} scenario should be displayed")
    public void message_for_scenario_should_be_displayed(String scenario) {

        Map<String, String> rowData=getScenarioData(scenario);

        String expectedMessage=rowData.get("expectedMessage");

        String actualMessage=wishlistAction.getSuccessMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected message: "+expectedMessage
                + " | Actual message: "+actualMessage);
    }

    @Then("searched product should be added to the wishlist")
    public void searched_product_should_be_added_to_the_wishlist() {

        wishlistAction.clickWishlistLink();

        String actualProduct=wishlistAction.getWishlistProductName();

        String expectedProduct=SearchStepDefinition.searchedProduct;

        Assert.assertEquals(actualProduct,expectedProduct,"Expected product: "+expectedProduct+" | Actual product: "
                +actualProduct);
    }

    @And("user removes the product from wishlist")
    public void user_removes_the_product_from_wishlist() {
        wishlistAction.clickWishlistLink();
        wishlistAction.removeProductFromWishlist();
    }

    @Then("wishlist should be empty")
    public void wishlist_should_be_empty() {

        String actualMessage=wishlistAction.getEmptyWishlistMessage();

        Assert.assertTrue(actualMessage.contains("The wishlist is empty"),"Expected wishlist empty message"+" | Actual message: "
                +actualMessage);
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

        String expectedProduct=SearchStepDefinition.searchedProduct;

        Assert.assertEquals(actualProduct,expectedProduct,"Expected cart product: "+expectedProduct
                + " | Actual cart product: "
                + actualProduct);
    }

    @And("user navigates to wishlist page")
    public void user_navigates_to_wishlist_page() {
        wishlistAction.clickWishlistLink();
    }

    @Then("product should be displayed in wishlist")
    public void product_should_be_displayed_in_wishlist() {

        String actualProduct=wishlistAction.getWishlistProductName();

        String expectedProduct=SearchStepDefinition.searchedProduct;

        Assert.assertEquals(actualProduct,expectedProduct,"Expected wishlist product: "
                +expectedProduct+" | Actual wishlist product: "+actualProduct);
    }

    @And("user clicks on the searched product")
    public void user_clicks_on_the_searched_product() {
        wishlistAction.openSearchedProduct(SearchStepDefinition.searchedProduct);
    }

    @And("clicks on Add to wishlist button")
    public void clicks_on_add_to_wishlist_button() {
        wishlistAction.clickAddToWishlist();
    }
}