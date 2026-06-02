package com.stepdefinitions;

import org.testng.Assert;

import com.actions.LoginAction;
import com.actions.ProductReviewAction;
import com.actions.checkoutAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductReviewStepDefinition {
	
	checkoutAction AC ;
	ProductReviewAction PRA;
	 LoginAction login;
	
	ProductReviewAction reviewAction;
	@Given("user is on the demoWebshop website")
	public void user_is_on_the_demo_webshop_website() {
		reviewAction = new ProductReviewAction(HelperClass.getDriver());
		HelperClass.getDriver().get(ConfigReader.get("app.url"));
		AC = new checkoutAction(HelperClass.getDriver());
		login = new LoginAction(HelperClass.getDriver());
		
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
	
	@When("the user login with valid creditials information")
	public void the_user_login_with_valid_creditials_information() {	
		login.clicklogin();
        login.userEmail(ConfigReader.getProperty("app.username"));
        login.userPassword(ConfigReader.getProperty("app.password"));
        login.clickloginbtn();
        

	}

	@When("the user give the reviewTile as {string}")
	public void the_user_give_the_review_tile_as(String string) {
		reviewAction.reviewTitle(string);
		
	}

	@When("the user give the reviewText as {string}")
	public void the_user_give_the_review_text_as(String string) {
		reviewAction.RevieGtext(string);
		
		
	}

	@When("the user click the submit review button")
	public void the_user_click_the_submit_review_button() {
		reviewAction.SubmitBtn();
		
	}

	@Then("the user should see the message of Product review is successfully added.")
	public void the_user_should_see_the_message_of_product_review_is_successfully_added() {
	    String act = reviewAction.getReviewSuccess();
	    String exp = "Product review is successfully added.";
	    Assert.assertEquals(act, exp);
	    System.out.println("Review done successful");
		
	}

}