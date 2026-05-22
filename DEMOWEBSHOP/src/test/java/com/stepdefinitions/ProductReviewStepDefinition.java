package com.stepdefinitions;

import org.testng.Assert;

import com.actions.ProductReviewAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductReviewStepDefinition {
	
	ProductReviewAction reviewAction;
	@Given("user is on the demoWebshop website")
	public void user_is_on_the_demo_webshop_website() {
		reviewAction = new ProductReviewAction(HelperClass.getDriver());
		HelperClass.getDriver().get(ConfigReader.get("app.url"));
		
	}
	
	@When("the user clicks on a product to view its details")
	public void the_user_clicks_on_a_product_to_view_its_details() {
		reviewAction.OpenReview();
	}

	@When("the user click  the review button")
	public void the_user_click_the_review_button() {
		reviewAction.clickReviewLink();
	}

	@Then("the user shoulod should redirect to the product review page and seen the text of product review")
	public void the_user_shoulod_should_redirect_to_the_product_review_page_and_seen_the_text_of_product_review() {
	    String act = reviewAction.revieText();
	    String exp = "Product reviews for ";
	    Assert.assertTrue(act.contains(exp));
	    System.out.println("the review page is open");
	}

	@Then("the user see the text of only registered users can write reviews")
	public void the_user_see_the_text_of_only_registered_users_can_write_reviews() {
		 String act = reviewAction.reviewFailText();
		    String exp = "Only registered users can write reviews";
		    Assert.assertTrue(act.contains(exp));
		    System.out.println("the review error message is occures");
	}

}
