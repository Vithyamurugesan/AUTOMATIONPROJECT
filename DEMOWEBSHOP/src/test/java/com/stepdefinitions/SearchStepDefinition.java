package com.stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.SearchActions;
import com.utilities.ConfigReader;
import com.utilities.CsvReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class SearchStepDefinition {

    private static final Logger log=LogManager.getLogger(SearchStepDefinition.class);
    private static final String CSV_FILE_PATH=ConfigReader.get("search.csv.path");

    private SearchActions searchActions;

    private String searchedProduct;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        log.info("Launching application");
        HelperClass.getDriver().get(ConfigReader.get("app.url"));
        
        searchActions = new SearchActions(HelperClass.getDriver());
        log.info("Home page loaded successfully");
    }

    @When("user enters product keyword in the search box")
    public void user_enters_product_keyword_in_the_search_box(DataTable dataTable) {

        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            performSearch(row.get("keyword"));
            Assert.assertTrue(searchActions.verifyResultsNotEmpty(),"Expected search results for : " + searchedProduct);
            navigateBackToHome();
        }
    }

    @When("user enters {string} type keyword in the search box")
    public void user_enters_type_keyword_in_the_search_box(String type) {

        List<Map<String, String>> data=CsvReader.getData(CSV_FILE_PATH);

        List<String> keywords=new ArrayList<>();

        for (Map<String, String> row : data) {
            if(row.get("type").equalsIgnoreCase(type)) {
                keywords.add(row.get("keyword"));
            }
        }

        if (keywords.isEmpty()){
            throw new IllegalArgumentException("No keyword found for search type : " + type);
        }

        for (String keyword : keywords) {

            performSearch(keyword);

            switch (type.toLowerCase()){

            case "valid":
                verifyValidSearch(keyword);
                log.info("Valid search verified for {}", keyword);
                break;

            case "invalid":
                Assert.assertTrue(searchActions.verifyNoProductMessage(),"Expected 'No products were found' message.");

                Assert.assertFalse(searchActions.verifyResultsNotEmpty(),"Unexpected products displayed.");
                log.info("Invalid search verified for {}", keyword);
                break;

            case "insensitive":

                Assert.assertTrue(searchActions.verifyResultsNotEmpty(),"No search results found.");
                Assert.assertTrue(searchActions.verifyResultsContainKeyword(keyword),"Keyword not found in search results.");
                log.info("Case insensitive search verified for {}", keyword);

                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported search type : " + type);
            }

            navigateBackToHome();
        }
    }

    @When("clicks on Search button")
    public void click_search() {

        log.info("Clicking search button");
        searchActions.clickSearch();
    }

    @Then("user should be redirected to the search results page")
    public void verify_redirect() {

        Assert.assertTrue(searchActions.verifySearchRedirect(),"User was not redirected to search results page.");
        log.info("Search redirect verified");
    }

    @Then("search results page should be displayed")
    public void verify_search_page() {

        Assert.assertTrue(searchActions.verifyResultsNotEmpty(),"Search results are empty.");
        log.info("Search results displayed");
    }

    @Then("no products message should be displayed")
    public void verify_no_products() {

        Assert.assertTrue(searchActions.verifyNoProductMessage(),"No product message is not displayed.");
        log.info("No product message verified");
    }

    @Then("matching products should be displayed")
    public void verify_products() {

        Assert.assertTrue(searchActions.verifyResultsNotEmpty(),"Expected search results for : " + searchedProduct);
        Assert.assertTrue(searchActions.verifyResultsContainKeyword(searchedProduct),"Matching product not found : " + searchedProduct);

        log.info("Matching products verified");
    }

    @When("user clicks on Search button without entering keyword")
    public void user_clicks_on_search_button_without_entering_keyword() {
        searchActions.clickSearch();
    }

    @Then("alert should be shown to the user")
    public void alert_should_be_shown_to_the_user() {

        Assert.assertTrue(searchActions.handleAlertIfPresent(),"Expected alert was not displayed.");
        log.info("Alert handled successfully");
    }

    @Then("warning message should be displayed to the user")
    public void warning_message_should_be_displayed_to_the_user() {

        Assert.assertTrue(searchActions.isWarningDisplayed(),"Warning message is not displayed.");
        log.info("Warning message verified");
    }

    // =======================
    // Helper Methods
    // =======================

    private void performSearch(String keyword) {
        searchedProduct = keyword;
        log.info("Searching product : {}", keyword);
        searchActions.searchProduct(keyword);
        searchActions.clickSearch();
    }

    private void navigateBackToHome() {
        HelperClass.getDriver().navigate().back();
    }

    private void verifyValidSearch(String keyword) {
        Assert.assertTrue(searchActions.verifySearchRedirect(),"Search page was not opened.");
        Assert.assertTrue(searchActions.verifyResultsNotEmpty(),"Search results are empty.");
        Assert.assertTrue(searchActions.verifyResultsContainKeyword(keyword),"Search results do not contain : " + keyword);
    }
}