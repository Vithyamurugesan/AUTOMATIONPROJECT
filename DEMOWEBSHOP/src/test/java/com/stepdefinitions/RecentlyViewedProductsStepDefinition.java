package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import com.actions.RecentlyViewedProductsAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecentlyViewedProductsStepDefinition {

	private static final Logger logger = LogManager.getLogger(RecentlyViewedProductsStepDefinition.class);

	RecentlyViewedProductsAction recentlyViewedProductsAction;

	@Given("User is on Demo Web Shop Website for Recently Viewed Products")
	public void user_is_on_demo_web_shop_website_for_recently_viewed_products() {

		logger.info("Launching Demo Web Shop for Recently Viewed Products testing");

		HelperClass.getDriver().get(ConfigReader.get("app.url"));

		recentlyViewedProductsAction = new RecentlyViewedProductsAction(HelperClass.getDriver());
	}

	@Given("User views the first product from recently viewed products test data")
	public void user_views_the_first_product_from_recently_viewed_products_test_data() {

		logger.info("Viewing first product from recently viewed products test data");

		recentlyViewedProductsAction.openFirstProductFromCsv(ConfigReader.get("recentlyviewed.csv.path"));
	}

	@Given("User views all products from recently viewed products test data")
	public void user_views_all_products_from_recently_viewed_products_test_data() {

		logger.info("Viewing all products from recently viewed products test data");

		recentlyViewedProductsAction.openAllProductsFromCsv(ConfigReader.get("recentlyviewed.csv.path"));
	}

	@When("User clicks on Recently viewed products link")
	public void user_clicks_on_recently_viewed_products_link() {

		logger.info("Clicking Recently viewed products link");

		recentlyViewedProductsAction.openRecentlyViewedProductsPage();
	}

	@Then("User should be navigated to Recently Viewed Products page")
	public void user_should_be_navigated_to_recently_viewed_products_page() {

		logger.info("Checking Recently Viewed Products page opened");

		Assert.assertTrue(recentlyViewedProductsAction.verifyRecentlyViewedProductsPage());
	}

	@Then("User should see the first product from test data displayed in Recently Viewed Products")
	public void user_should_see_the_first_product_from_test_data_displayed_in_recently_viewed_products() {

		logger.info("Checking first viewed product is displayed");

		Assert.assertTrue(recentlyViewedProductsAction.verifyFirstVisitedProductDisplayed());
	}

	
}
