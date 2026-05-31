package com.stepdefinitions;

import org.testng.Assert;

import com.actions.CompareAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CompareStepDefinition {

	CompareAction compareAction = new CompareAction(HelperClass.getDriver());
	
	@Given("User launches Demo Web Shop app")
	public void user_launches_demo_web_shop_compare_page() {

	    HelperClass.getDriver().get(ConfigReader.get("app.url"));
	}

	@Given("User clicks on Jewelry category")
	public void user_clicks_on_jewelry_category() {

		compareAction.openJewelryPage();
	}

	@Given("User clicks on Black And White Diamond Heart product")
	public void user_clicks_on_black_and_white_diamond_heart_product() {

	    compareAction.openProduct("Black & White Diamond Heart");
	}

	@When("User clicks on Add To Compare button")
	public void user_clicks_on_add_to_compare_button() {

		compareAction.clickAddToCompare();
	}

	@When("User clicks on Compare Products link")
	public void user_clicks_on_compare_products_link() {

		compareAction.openCompareProductsPage();
	}

	@Then("User should navigate to compare products page")
	public void user_should_navigate_to_compare_products_page() {

		Assert.assertTrue(compareAction.verifyComparePage());
	}

	@Then("User should see selected compare product in compare products page")
	public void user_should_see_selected_compare_product_in_compare_products_page() {

		Assert.assertTrue(compareAction.verifyComparedProducts());
	}

	@When("User adds multiple compare products from test data")
	public void user_adds_multiple_compare_products_from_test_data() {

		compareAction.addProductsFromExcel(ConfigReader.get("compare.excel.path"),
				ConfigReader.get("compare.sheet.name"));
	}

	@Then("User should see all added products in compare products page")
	public void user_should_see_all_added_products_in_compare_products_page() {

		Assert.assertTrue(compareAction.verifyComparedProducts());
	}

	@When("User adds below compare products to compare list")
	public void user_adds_below_compare_products_to_compare_list(DataTable table) {

		compareAction.addProducts(table);
	}

	@When("User removes below compare product")
	public void user_removes_below_compare_product(DataTable table) {

		String product = table.asMaps().get(0).get("product");

		compareAction.removeProduct(product);
	}

	@Then("User should not see removed product in compare products page")
	public void user_should_not_see_removed_product_in_compare_products_page(DataTable table) {

	    String product = table.asMaps().get(0).get("product");

	    Assert.assertTrue(compareAction.verifyRemovedProduct(product));
	}

	@Then("User should see remaining products in compare products page")
	public void user_should_see_remaining_products_in_compare_products_page(DataTable table) {

	    String product = table.asMaps().get(0).get("product");

	    Assert.assertTrue(compareAction.verifyRemainingProduct(product));
	}
	
	@When("User adds {string} product to compare list")
	public void user_adds_product_to_compare_list(String product) {

		compareAction.addSingleProduct(product);
	}

	@When("User clicks on Clear List button")
	public void user_clicks_on_clear_list_button() {

		compareAction.clearCompareList();
	}

	@Then("User should see compare list is empty")
	public void user_should_see_compare_list_is_empty() {

		Assert.assertTrue(compareAction.verifyEmptyCompareList());
	}
}