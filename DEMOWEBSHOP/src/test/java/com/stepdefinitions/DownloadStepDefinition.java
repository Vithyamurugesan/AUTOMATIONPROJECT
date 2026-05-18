package com.stepdefinitions;

import io.cucumber.java.en.When;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.actions.DownloadProductAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.Then;

public class DownloadStepDefinition {
	WebDriver driver;
	DownloadProductAction download;
	public DownloadStepDefinition() {
		driver = HelperClass.getDriver();
		download=new DownloadProductAction(driver);
	}

	@When("the user clicks the My account link")
	public void the_user_clicks_the_my_account_link() {
		download.waitforMyAccountlink();
		download.clickMyAccount();
	}

	@When("the user clicks the Downloadable products link")
	public void the_user_clicks_the_downloadable_products_link() {
		
		download.clickDownload();
	}

	@Then("the user should be able to see the previously downloaded product details")
	public void the_user_should_be_able_to_see_the_previously_downloaded_product_details() {
		System.out.println("the count of download product: "+download.countofordownloadProduct());
		List<String> products = download.getAllProductNames();
		System.out.println("All Products: " + products);
	}

}
