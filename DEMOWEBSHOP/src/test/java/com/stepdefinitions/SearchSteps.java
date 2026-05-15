package com.stepdefinitions;

import org.testng.Assert;

import com.actions.SearchActions;
import com.utilities.HelperClass;
import com.utilities.PropertyManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	SearchActions searchActions;

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
		searchActions =new SearchActions(HelperClass.getDriver());
	}

	@When("user enters valid product keyword in the search box")
	public void valid_search() {
		searchActions.searchProduct(PropertyManager.getTestDataValue("validProduct"));
	}

	@When("user enters invalid product keyword in the search box")
	public void invalid_search() {
		searchActions.searchProduct(PropertyManager.getTestDataValue("invalidProduct"));
	}

	@When("user enters product keyword in uppercase")
	public void uppercase_search() {
		searchActions.searchProduct(PropertyManager.getTestDataValue("uppercaseProduct"));
	}

	@When("clicks on Search button")
	public void click_search() {
		searchActions.clickSearch();
	}

	@Then("user should be redirected to the search results page")
	public void verify_redirect() {
		Assert.assertTrue(searchActions.verifySearchResultPage());
	}

	@Then("search results page should be displayed")
	public void verify_search_page() {
		Assert.assertTrue(searchActions.verifySearchResultPage());
	}

	@Then("no products message should be displayed")
	public void verify_no_products() {
		Assert.assertTrue(searchActions.verifyNoProductMessage());
	}

	@Then("matching products should be displayed")
	public void verify_products() {
		Assert.assertTrue(searchActions.verifySearchResultPage());
	}
	
	@When("user clicks on Search button without entering keyword")
	public void user_clicks_on_search_button_without_entering_keyword() {
		searchActions.clickSearch();
	}

	@Then("alert should be shown to the user")
	public void alert_should_be_shown_to_the_user() {
		Assert.assertTrue(searchActions.isWarningDisplayed());
	}
}
