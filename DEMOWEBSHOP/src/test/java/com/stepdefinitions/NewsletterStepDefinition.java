package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.actions.NewsletterAction;
import com.utilities.ConfigReader;
import com.utilities.CsvReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.*;

public class NewsletterStepDefinition {

    NewsletterAction newsletterAction =
            new NewsletterAction(HelperClass.getDriver());

    String filePath = "src/test/resources/TestData/newsletter.csv";

    List<Map<String, String>> testData =
            CsvReader.getData(filePath);

    @Given("User opens Demo Web Shop homepage")
    public void user_opens_demo_web_shop_homepage() {

        WebDriver driver = HelperClass.getDriver();
        driver.get(ConfigReader.get("app.url"));
    }

    @Given("User enters newsletter email from test data")
    public void user_enters_newsletter_email_from_test_data() {

        Map<String, String> data = testData.get(0);

        newsletterAction.enterNewsletterEmail(data.get("email"));
    }

    @When("User clicks on Subscribe button")
    public void user_clicks_on_subscribe_button() {

        newsletterAction.clickSubscribeButton();
    }

    @Then("User should see newsletter subscription success message")
    public void user_should_see_newsletter_subscription_success_message() {

        String expected =
                "Thank you for signing up! A verification email has been sent. We appreciate your interest.";

        String actual = newsletterAction.getSubscriptionMessage();

        Assert.assertEquals(actual, expected);
    }

}