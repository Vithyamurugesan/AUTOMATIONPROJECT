package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.CatalogActions;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogStepDefinition {

    private static final Logger log = LogManager.getLogger(CatalogStepDefinition.class);

    CatalogActions catalogActions;

    @Given("user is on the demowebshop home page for Categories")
    public void user_is_on_the_demowebshop_home_page_for_categories() {
    	HelperClass.getDriver().get(ConfigReader.get("app.url"));
        catalogActions = new CatalogActions(HelperClass.getDriver());
        log.info("User navigated to demowebshop home page");
    }
    
    @When("user clicks on the Computers category from top menu")
    public void user_clicks_on_the_computers_category_from_top_menu() {
        catalogActions.clickComputersCategory();
    }

    @When("user clicks on the Electronics category from top menu")
    public void user_clicks_on_the_electronics_category_from_top_menu() {
        catalogActions.clickElectronicsCategory();
    }

    @When("user clicks on the Books category from top menu")
    public void user_clicks_on_the_books_category_from_top_menu() {
        catalogActions.clickBooksCategory();
    }

    @When("user clicks on the Apparel and Shoes category from top menu")
    public void user_clicks_on_the_apparel_and_shoes_category_from_top_menu() {
        catalogActions.clickApparelCategory();
    }

    @When("user clicks on the Gift Cards category from top menu")
    public void user_clicks_on_the_gift_cards_category_from_top_menu() {
        catalogActions.clickGiftCardsCategory();
    }

    @Then("user should be navigated to the selected category page")
    public void user_should_be_navigated_to_the_selected_category_page() {
        log.info("Verifying category page title is displayed");
        Assert.assertTrue(catalogActions.isCategoryPageTitleDisplayed(),
                "Category page title should be visible after navigation");
    }

    @Then("the category page title should be displayed")
    public void the_category_page_title_should_be_displayed() {
        String title = catalogActions.getCategoryPageTitle();
        log.info("Asserting category page has a non-empty title: {}", title);
        Assert.assertFalse(title.isEmpty(), "Category page title should not be empty");
    }

    @Then("products should be listed in the catalog")
    public void products_should_be_listed_in_the_catalog() {
        log.info("Verifying products are listed in catalog grid");
        Assert.assertTrue(catalogActions.areProductsDisplayed(),
                "At least one product should be displayed in the catalog");
    }

    @Then("the product grid should be visible on the page")
    public void the_product_grid_should_be_visible_on_the_page() {
        log.info("Verifying product grid is visible");
        Assert.assertTrue(catalogActions.isProductGridDisplayed(),
                "Product grid should be visible on the catalog page");
    }
}