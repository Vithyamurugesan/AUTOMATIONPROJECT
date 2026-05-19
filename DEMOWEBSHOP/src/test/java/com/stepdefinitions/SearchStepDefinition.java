package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.SearchActions;
import com.utilities.ConfigReader;
import com.utilities.CsvReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinition {

    SearchActions searchActions;

    public static String searchedProduct;

    static final String CSV_FILE_PATH="src/test/resources/testdata/searchKeywords.csv";

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        HelperClass.getDriver().get(ConfigReader.get("app.url"));
        searchActions=new SearchActions(HelperClass.getDriver());
    }

    @When("user enters product keyword in the search box")
    public void user_enters_product_keyword_in_the_search_box(
            DataTable dataTable) {

        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);

        String keyword=data.get(0).get("keyword");

        searchedProduct=keyword;
        searchActions.searchProduct(keyword);
    }

    @When("user enters {string} type keyword in the search box")
    public void user_enters_type_keyword_in_the_search_box(
            String type) {

        List<Map<String, String>> data=CsvReader.getData(CSV_FILE_PATH);

        String keyword=null;

        for (Map<String, String> row : data) {
            if (row.get("type").equalsIgnoreCase(type)) {
                keyword=row.get("keyword");
                break;
            }
        }

        if (keyword==null) {
            throw new RuntimeException("No keyword found for type: " + type);
        }

        searchedProduct=keyword;
        searchActions.searchProduct(keyword);
    }

    @When("clicks on Search button")
    public void click_search() {
        searchActions.clickSearch();
    }

    @Then("user should be redirected to the search results page")
    public void verify_redirect() {
        Assert.assertTrue(searchActions.verifySearchRedirect());
    }

    @Then("search results page should be displayed")
    public void verify_search_page() {
        Assert.assertTrue(searchActions.verifyResultsNotEmpty());
    }

    @Then("no products message should be displayed")
    public void verify_no_products() {
        Assert.assertTrue(searchActions.verifyNoProductMessage());
    }

    @Then("matching products should be displayed")
    public void verify_products() {
        Assert.assertTrue(searchActions.verifyResultsNotEmpty());
        Assert.assertTrue(searchActions.verifyResultsContainKeyword(searchedProduct));
    }

    @When("user clicks on Search button without entering keyword")
    public void user_clicks_on_search_button_without_entering_keyword() {
        searchActions.clickSearch();
    }

    @Then("alert should be shown to the user")
    public void alert_should_be_shown_to_the_user() {
        Assert.assertTrue(searchActions.handleAlertIfPresent());
    }

    @Then("warning message should be displayed to the user")
    public void warning_message_should_be_displayed_to_the_user() {
        Assert.assertTrue(searchActions.handleAlertIfPresent());
    }
}