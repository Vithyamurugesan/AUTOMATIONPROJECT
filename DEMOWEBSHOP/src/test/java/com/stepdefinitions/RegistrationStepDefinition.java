package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.RegistrationActions;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;
import com.utilities.TestDataReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition {

    RegistrationActions registrationActions;

    String path =System.getProperty("user.dir")+ "\\TestData\\TestData.xlsx";

    String sheetName = "Sheet2";


    @Given("the user is on the DemoWebShop homepage")
    public void the_user_is_on_the_demo_web_shop_homepage() {

        HelperClass.getDriver()
                .get(ConfigReader.get("app.url"));

        registrationActions =
                new RegistrationActions(
                        HelperClass.getDriver());
    }


    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String link) {

        if(link.equalsIgnoreCase("Register")) {

            registrationActions.clickRegisterLink();
        }
    }


    @And("the user enters firstname {string}")
    public void the_user_enters_firstname(String firstname) {

        registrationActions.enterFirstName(firstname);
    }


    @And("the user enters lastname {string}")
    public void the_user_enters_lastname(String lastname) {

        registrationActions.enterLastName(lastname);
    }


    @And("the user enters email {string}")
    public void the_user_enters_email(String email) {

        registrationActions.enterEmail(email);
    }


    @And("the user enters password {string}")
    public void the_user_enters_password(String password) {

        registrationActions.enterPassword(password);
    }


    @And("the user enters confirm password {string}")
    public void the_user_enters_confirm_password(
            String confirmPassword) {

        registrationActions
                .enterConfirmPassword(confirmPassword);
    }


    @And("the user enters registration details from excel row {string}")
    public void the_user_enters_registration_details_from_excel_row(
            String rowValue) {

        int row = Integer.parseInt(rowValue);

        registrationActions.enterRegistrationDetailsFromExcel(path,sheetName,row);
    }


    @And("the user enters existing user data from properties file")
    public void the_user_enters_existing_user_data_from_properties_file() {

        registrationActions.enterFirstName(TestDataReader.get("firstname"));

        registrationActions.enterLastName(TestDataReader.get("lastname"));

        registrationActions.enterEmail(TestDataReader.get("existingemail"));

        registrationActions.enterPassword(TestDataReader.get("password"));

        registrationActions.enterConfirmPassword(TestDataReader.get("confirmPassword"));
    }


    @And("the user clicks the {string} button")
    public void the_user_clicks_the_button(String button) {

        if(button.equalsIgnoreCase("Register")) {

            registrationActions.clickRegisterButton();
        }

        else if(button.equalsIgnoreCase("Continue")) {

            registrationActions.clickContinueButton();
        }
    }


    @Then("the page should display the message Your registration completed")
    public void the_page_should_display_the_message() {

        Assert.assertEquals(
                registrationActions
                        .getRegistrationSuccessMessage(),

                TestDataReader.get("successmessage"));
    }


    @Then("the email error message {string} should be displayed")
    public void the_email_error_message_should_be_displayed(
            String expectedMessage) {

        Assert.assertEquals(

                registrationActions.getEmailErrorMessage(),

                expectedMessage);
    }


    @Then("the confirm password error message {string} should be displayed")
    public void the_confirm_password_error_message_should_be_displayed(
            String expectedMessage) {

        Assert.assertEquals(

                registrationActions
                        .getConfirmPasswordErrorMessage(),

                expectedMessage);
    }


    @Then("the page should display the error The specified email already exists")
    public void the_page_should_display_the_existing_email_error() {

        Assert.assertEquals(

                registrationActions
                        .getExistingEmailErrorMessage(),

                TestDataReader.get("existingemailerror"));
    }


    @Then("the following validation messages should be displayed")
    public void the_following_validation_messages_should_be_displayed(
            DataTable dataTable) {

        List<Map<String, String>> data =

                dataTable.asMaps(String.class,
                        String.class);

        for(Map<String, String> row : data) {

            String field =
                    row.get("Field");

            String expectedMessage =
                    row.get("Message");

            switch(field) {

                case "FirstName":
                    Assert.assertEquals(registrationActions.getFirstNameErrorMessage(),expectedMessage);
                    break;


                case "LastName":
                    Assert.assertEquals(registrationActions.getLastNameErrorMessage(),expectedMessage);
                    break;

                case "Email":

                    Assert.assertEquals(registrationActions.getEmailErrorMessage(),expectedMessage);
                    break;

                case "Password":

                    Assert.assertEquals( registrationActions .getPasswordErrorMessage(),expectedMessage);
                    break;
            }
        }
    }
}