package com.stepdefinitions;

import org.testng.Assert;

import com.actions.SocialMediaLinkAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;


public class SocialMediaLinkStepDefinition {
	
	private SocialMediaLinkAction linkAction;
	
	private ThreadLocal<Boolean> isNavigated = new ThreadLocal<>();
	
	@Given("user is on the Demo Web Shop home page")
	public void user_is_on_the_demo_web_shop_home_page() {
		HelperClass.getDriver().get(ConfigReader.get("app.url"));
		linkAction=new SocialMediaLinkAction(HelperClass.getDriver());
	}

	@When("user clicks on {string} link")
	public void user_clicks_on_link(String string) {
		isNavigated.set(linkAction.clickMedia(string));
	}

	@Then("user should be redirected to appropriate page")
	public void user_should_be_redirected_to_appropriate_page() {
		Assert.assertTrue(isNavigated.get());
	}

}
