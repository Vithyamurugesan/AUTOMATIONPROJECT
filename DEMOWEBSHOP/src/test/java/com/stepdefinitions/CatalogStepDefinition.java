package com.stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.CatalogActions;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
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

        log.info("Navigated to home page");
    }


    @When("user clicks on the Computers category from top menu")
    public void click_computers_category() {

        log.info("Clicking Computers category");

        catalogActions.clickCategory("Computers");
    }

    @When("user clicks on the Electronics category from top menu")
    public void click_electronics_category() {

        log.info("Clicking Electronics category");

        catalogActions.clickCategory("Electronics");
    }

    @When("user clicks on the Books category from top menu")
    public void click_books_category() {

        log.info("Clicking Books category");

        catalogActions.clickCategory("Books");
    }

    @When("user clicks on the Apparel and Shoes category from top menu")
    public void click_apparel_category() {

        log.info("Clicking Apparel & Shoes category");

        catalogActions.clickCategory("Apparel & Shoes");
    }

    @When("user clicks on the Gift Cards category from top menu")
    public void click_giftcards_category() {

        log.info("Clicking Gift Cards category");

        catalogActions.clickCategory("Gift Cards");
    }



    @When("user clicks on the Desktops subcategory")
    public void click_desktops_subcategory() {

        log.info("Clicking Desktops subcategory");

        catalogActions.clickSubCategory("Desktops");
    }

 

    @Then("user should be navigated to computers page url")
    public void validate_computers_url() {

        Assert.assertTrue(
                catalogActions.verifyCurrentUrl("computers"),
                "Computers URL validation failed");
    }

    @Then("user should be navigated to desktops page url")
    public void validate_desktops_url() {

        Assert.assertTrue(
                catalogActions.verifyCurrentUrl("desktops"),
                "Desktops URL validation failed");
    }

   

    @Then("product grid should be displayed")
    public void product_grid_should_be_displayed() {

        Assert.assertTrue(
                catalogActions.isProductGridDisplayed(),
                "Product grid is not displayed");
    }

    @Then("displayed product count should be greater than 0")
    public void displayed_product_count_should_be_greater_than_0() {

        int count = catalogActions.getDisplayedProductCount();

        log.info("Product count: " + count);

        Assert.assertTrue(count > 0,
                "No products displayed");
    }

    @Then("breadcrumb should contain Computers")
    public void breadcrumb_computers() {

        Assert.assertTrue(
                catalogActions.getBreadcrumbText().contains("COMPUTERS"));
    }

    @Then("breadcrumb should contain Desktops")
    public void breadcrumb_desktops() {

        Assert.assertTrue(
                catalogActions.getBreadcrumbText().contains("DESKTOPS"));
    }

    @Then("breadcrumb should contain Apparel & Shoes")
    public void breadcrumb_apparel() {

        Assert.assertTrue(
                catalogActions.getBreadcrumbText().contains("APPAREL & SHOES"));
    }



    @Then("user should see the following products")
    public void user_should_see_the_following_products(DataTable dataTable) {

        List<String> expectedProducts = dataTable.asList();

        List<String> actualProducts = catalogActions.getDisplayedProducts();

        log.info("Expected products: " + expectedProducts);

        log.info("Actual products: " + actualProducts);

        Assert.assertTrue(
                actualProducts.containsAll(expectedProducts),
                "Expected products not found");
    }
}