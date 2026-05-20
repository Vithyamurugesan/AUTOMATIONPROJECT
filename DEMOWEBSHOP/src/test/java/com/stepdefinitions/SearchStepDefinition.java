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

    private static final Logger log = LogManager.getLogger(SearchStepDefinition.class);

    SearchActions searchActions;
    public String searchedProduct;

    static final String CSV_FILE_PATH = ConfigReader.get("search.csv.path");

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {

        log.info("Launching application URL");

        HelperClass.getDriver().get(ConfigReader.get("app.url"));
        searchActions=new SearchActions(HelperClass.getDriver());

        log.info("Home page loaded successfully");
    }

    @When("user enters product keyword in the search box")
    public void user_enters_product_keyword_in_the_search_box(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {

            String keyword=row.get("keyword");
            searchedProduct=keyword;

            log.info("Searching product : " + keyword);

            searchActions.searchProduct(keyword);
            searchActions.clickSearch();

            Assert.assertTrue(searchActions.verifyResultsNotEmpty());

            log.info("Assertion passed for : " + keyword);
            HelperClass.getDriver().navigate().back();
        }
    }

    @When("user enters {string} type keyword in the search box")
    public void user_enters_type_keyword_in_the_search_box(String type) {

    	 List<Map<String, String>> data = CsvReader.getData(CSV_FILE_PATH);

    	    List<String> keywords = new ArrayList<>();

    	    for (Map<String, String> row : data) {
    	        if (row.get("type").equalsIgnoreCase(type)) {
    	            keywords.add(row.get("keyword"));
    	        }
    	    }

    	    if (keywords.isEmpty()) {
    	        log.error("No keyword found for type : " + type);
    	        throw new RuntimeException("No keyword found for type : " + type);
    	    }

    	    for (String keyword : keywords) {

    	        searchedProduct=keyword;
    	        log.info("Searching product : " + keyword);

    	        try {
    	            searchActions.searchProduct(keyword);
    	            searchActions.clickSearch();

    	            if (type.equalsIgnoreCase("valid")) {

    	                Assert.assertTrue(searchActions.verifySearchRedirect());
    	                Assert.assertTrue(searchActions.verifyResultsNotEmpty());
    	                Assert.assertTrue(searchActions.verifyResultsContainKeyword(keyword));
    	                
    	                log.info("Valid search assertions passed for : " + keyword);

    	            }
    	            else if (type.equalsIgnoreCase("invalid")) {

    	                Assert.assertTrue(searchActions.verifyNoProductMessage());
    	                Assert.assertFalse(searchActions.verifyResultsNotEmpty());
    	                
    	                log.info("Invalid search assertions passed for : " + keyword);

    	            }
    	            else if (type.equalsIgnoreCase("insensitive")) {

    	                Assert.assertTrue(searchActions.verifyResultsNotEmpty());
    	                Assert.assertTrue(searchActions.verifyResultsContainKeyword(keyword));
    	                
    	                log.info("Case-insensitive assertions passed for : " + keyword);
    	            }

    	        }
    	        finally {
    	            HelperClass.getDriver().navigate().back();
    	        }
    	    }
    }

    @When("clicks on Search button")
    public void click_search() {
        log.info("Clicking search button");
        searchActions.clickSearch();
    }

    @Then("user should be redirected to the search results page")
    public void verify_redirect() {
        log.debug("Verifying search redirect");
        Assert.assertTrue(searchActions.verifySearchRedirect());
        log.info("User redirected to search results page");
    }

    @Then("search results page should be displayed")
    public void verify_search_page() {
        log.debug("Checking search results page");
        Assert.assertTrue(searchActions.verifyResultsNotEmpty());
        log.info("Search results displayed");
    }

    @Then("no products message should be displayed")
    public void verify_no_products() {
        log.debug("Checking no product message");
        Assert.assertTrue(searchActions.verifyNoProductMessage());
        log.info("No product message verified");
    }

    @Then("matching products should be displayed")
    public void verify_products() {
        log.info("Validating results for: {}", searchedProduct);
        Assert.assertTrue(searchActions.verifyResultsNotEmpty());
        Assert.assertTrue(searchActions.verifyResultsContainKeyword(searchedProduct));
        log.info("Matching products validated successfully");
    }

    @When("user clicks on Search button without entering keyword")
    public void user_clicks_on_search_button_without_entering_keyword() {
        log.info("Clicking search without keyword");
        searchActions.clickSearch();
    }

    @Then("alert should be shown to the user")
    public void alert_should_be_shown_to_the_user() {
        log.info("Handling alert popup");
        Assert.assertTrue(searchActions.handleAlertIfPresent());
        log.info("Alert handled successfully");
    }

    @Then("warning message should be displayed to the user")
    public void warning_message_should_be_displayed_to_the_user() {
        log.info("Validating warning message");
        Assert.assertTrue(searchActions.handleAlertIfPresent());
        log.info("Warning message verified");
    }
}