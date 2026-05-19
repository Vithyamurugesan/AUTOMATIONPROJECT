package com.stepdefinitions;

import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebDriver;

import com.actions.DownloadProductAction;
import com.utilities.HelperClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Then;

public class DownloadStepDefinition {
	WebDriver driver;
	DownloadProductAction download;
	private static final Logger log = LogManager.getLogger(DownloadStepDefinition.class);
	public DownloadStepDefinition() {
		driver = HelperClass.getDriver();
		download=new DownloadProductAction(driver);
	}

	@When("the user clicks the My account link")
	public void the_user_clicks_the_my_account_link() {
		log.info("User clicks My Account link");
		download.waitforMyAccountlink();
		download.clickMyAccount();
	}

	@When("the user clicks the Downloadable products link")
	public void the_user_clicks_the_downloadable_products_link() {
		log.info("User clicks Downloadable Products link");
		download.clickDownload();
	}

	@Then("the user should be able to see the previously downloaded product details")
	public void the_user_should_be_able_to_see_the_previously_downloaded_product_details() {
		int count = download.countofordownloadProduct();
		log.info("Count of downloaded products: {}", count);
		List<String> products = download.getAllProductNames();
		log.info("Downloaded Product List: {}", products);
	}
}