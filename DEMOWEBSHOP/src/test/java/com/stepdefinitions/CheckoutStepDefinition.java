package com.stepdefinitions;

import org.testng.Assert;

import com.actions.checkoutAction;
import com.pages.checkoutPage;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDefinition {
	
	checkoutAction AC ;
	
	@Given("user is on the demoWebPage website")
	public void user_is_on_the_demo_web_page_website() {
		 AC= new checkoutAction(HelperClass.getDriver());
		 HelperClass.getDriver().get("https://demowebshop.tricentis.com/");
	}

	@Given("user is login the demo web shop website with minium adding of one product")
	public void user_is_login_the_demo_web_shop_website_with_minium_adding_of_one_product() {
	   AC.productAddInCart();
	}

	@When("the user click the checkbox of terms and conditions")
	public void the_user_click_the_checkbox_of_terms_and_conditions() {
    AC.click_checkBox();
	}

	@When("the user click the checkout button")
	public void the_user_click_the_checkout_button() {
		AC.click_checkout();
	}

	@Then("the user redirect to the checkout page and seen the text of checkout")
	public void the_user_redirect_to_the_checkout_page_and_seen_the_text_of_checkout() {
		String exp="Checkout";
		String act=AC.checkoutPage();
		Assert.assertEquals(act, exp);
		System.out.println("Checkout page displayed");
	}
}