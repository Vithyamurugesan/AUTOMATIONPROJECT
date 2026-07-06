package com.stepdefinitions;

import org.testng.Assert;

import com.actions.CustomerAccountAction;
import com.actions.LoginAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerAccountStepDef {

    CustomerAccountAction accountAction;
    LoginAction loginAction;

    @Given("user navigates to the demowebshop for account management")
    public void user_navigates_to_the_demowebshop_for_account_management() {

        accountAction = new CustomerAccountAction(HelperClass.getDriver());
        loginAction = new LoginAction(HelperClass.getDriver());

        HelperClass.getDriver().get(ConfigReader.get("app.url"));
    }

    @When("the user logs in for account management")
    public void the_user_logs_in_for_account_management() {

        loginAction.clicklogin();
        loginAction.userEmail(ConfigReader.get("app.username"));
        loginAction.userPassword(ConfigReader.get("app.password"));
        loginAction.clickloginbtn();
    }

    @When("the user clicks on their account email link at the top of the page")
    public void the_user_clicks_on_their_account_email_link_at_the_top_of_the_page() {

        accountAction.clickAccountLink();
    }

    @When("the user updates their first name to {string}")
    public void the_user_updates_their_first_name_to(String firstName) {

        accountAction.updateFirstName(firstName);
    }

    @When("the user clicks the Save button on the customer info page")
    public void the_user_clicks_the_save_button_on_the_customer_info_page() {

        accountAction.clickSaveInfoButton();
    }

    @Then("the user should remain on the customer info page and see the updated first name {string} in the first name field")
    public void the_user_should_remain_on_the_customer_info_page_and_see_the_updated_first_name_in_the_first_name_field(String expectedName) {

        String actualName = accountAction.getFirstNameValue();

        Assert.assertEquals(actualName, expectedName,
                "Updated first name does not match!");
    }
}