package com.stepdefinitions;

import org.testng.Assert;

import com.actions.SortingAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class SortingStepDefinition {
	
	private SortingAction sortAction;
	
	@Given("user navigates to the Book section")
	public void user_navigates_to_the_book_section() {
		sortAction=new SortingAction(HelperClass.getDriver());
		sortAction.navigateToBooks();
	}

	@When("user selects {string} sorting")
	public void user_selects_sorting(String option) {
		sortAction.selectOption(option);
	}

	@Then("the products should be sorted in {string} order")
	public void the_products_should_be_sorted_in_order(String order) {
		Assert.assertTrue(sortAction.isSorted(order));
	}

}
