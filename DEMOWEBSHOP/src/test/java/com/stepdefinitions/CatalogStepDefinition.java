package com.stepdefinitions;

import java.util.List;

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
        log.info("Navigated to home page: " + ConfigReader.get("app.url"));
    }

    @When("user clicks on the {string} category from top menu")
    public void user_clicks_on_the_category_from_top_menu(String categoryName) {
        log.info("Clicking category: " + categoryName);
        catalogActions.clickCategory(categoryName);
    }

    @When("user clicks on the {string} subcategory")
    public void user_clicks_on_the_subcategory(String subCategoryName) {
        log.info("Clicking subcategory: " + subCategoryName);
        catalogActions.clickSubCategory(subCategoryName);
    }

    @Then("user should be navigated to {string} page url")
    public void user_should_be_navigated_to_page_url(String expectedUrlPart) {
        String currentUrl = HelperClass.getDriver().getCurrentUrl();
        log.info("Current URL: " + currentUrl + " | Expected to contain: " + expectedUrlPart);
        Assert.assertTrue(
            catalogActions.verifyCurrentUrl(expectedUrlPart),
            "URL validation failed. Current: " + currentUrl + " | Expected to contain: " + expectedUrlPart
        );
    }

    @Then("product grid should be displayed")
    public void product_grid_should_be_displayed() {
        boolean displayed = catalogActions.isProductGridDisplayed();
        log.info("Product grid displayed: " + displayed);
        Assert.assertTrue(displayed, "Product grid is not displayed");
    }

    @Then("displayed product count should be greater than 0")
    public void displayed_product_count_should_be_greater_than_0() {
        int count = catalogActions.getDisplayedProductCount();
        log.info("Product count: " + count);
        Assert.assertTrue(count > 0, "No products or subcategories displayed. Count: " + count);
    }

    @Then("breadcrumb should contain {string}")
    public void breadcrumb_should_contain(String expectedText) {
        String actualBreadcrumb = catalogActions.getBreadcrumbText();
        log.info("Breadcrumb actual: " + actualBreadcrumb + " | Expected to contain: " + expectedText.toUpperCase());
        Assert.assertTrue(
            actualBreadcrumb.contains(expectedText.toUpperCase()),
            "Breadcrumb validation failed. Actual: " + actualBreadcrumb + " | Expected to contain: " + expectedText.toUpperCase()
        );
    }

    @Then("user should see the following products")
    public void user_should_see_the_following_products(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedProducts = dataTable.asList();
        List<String> actualProducts = catalogActions.getDisplayedProducts();
        log.info("Expected products: " + expectedProducts);
        log.info("Actual products:   " + actualProducts);
        Assert.assertTrue(
            actualProducts.containsAll(expectedProducts),
            "Expected products not found. Expected: " + expectedProducts + " | Actual: " + actualProducts
        );
    }

    @Then("category list should contain {string}")
    public void category_list_should_contain(String expectedCategory) {
        log.info("Checking category present: " + expectedCategory);
        Assert.assertTrue(
            catalogActions.verifyCategoryPresent(expectedCategory),
            "Category not found: " + expectedCategory
        );
    }
}