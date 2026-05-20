package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.RegistrationActions;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;
import com.utilities.TestDataReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition {

	private static final Logger logger = LogManager.getLogger(RegistrationStepDefinition.class);

	RegistrationActions registrationActions;

	String path = System.getProperty("user.dir")  + "/src/test/resources/TestData/TestData.xlsx";

	String sheetName = "Sheet2";

	@Given("the user is on the DemoWebShop homepage")
	public void the_user_is_on_the_demo_web_shop_homepage() {

		logger.info("Launching DemoWebShop application");

		HelperClass.getDriver().get(ConfigReader.get("app.url"));

		registrationActions = new RegistrationActions(HelperClass.getDriver());

		logger.info("DemoWebShop homepage launched successfully");
	}

	@When("the user clicks the {string} link")
	public void the_user_clicks_the_link(String link) {

		logger.info("User clicks on link: " + link);

		if (link.equalsIgnoreCase("Register")) {

			registrationActions.clickRegisterLink();

			logger.info("Register link clicked successfully");
		}
	}

	@And("the user enters firstname {string}")
	public void the_user_enters_firstname(String firstname) {

		logger.info("Entering firstname: " + firstname);

		registrationActions.enterFirstName(firstname);
	}

	@And("the user enters lastname {string}")
	public void the_user_enters_lastname(String lastname) {

		logger.info("Entering lastname: " + lastname);

		registrationActions.enterLastName(lastname);
	}

	@And("the user enters email {string}")
	public void the_user_enters_email(String email) {

		logger.info("Entering email: " + email);

		registrationActions.enterEmail(email);
	}

	@And("the user enters password {string}")
	public void the_user_enters_password(String password) {

		logger.info("Entering password");

		registrationActions.enterPassword(password);
	}

	@And("the user enters confirm password {string}")
	public void the_user_enters_confirm_password(String confirmPassword) {

		logger.info("Entering confirm password");

		registrationActions.enterConfirmPassword(confirmPassword);
	}

	@And("the user enters registration details from excel row {string}")
	public void the_user_enters_registration_details_from_excel_row(String rowValue) {

		logger.info("Entering registration details from excel row: " + rowValue);

		int row = Integer.parseInt(rowValue);

		registrationActions.enterRegistrationDetailsFromExcel(path, sheetName, row);

		logger.info("Excel data entered successfully");
	}

	@And("the user enters existing user data from properties file")
	public void the_user_enters_existing_user_data_from_properties_file() {

		logger.info("Entering existing user data from properties file");

		registrationActions.enterFirstName(TestDataReader.get("firstname"));

		registrationActions.enterLastName(TestDataReader.get("lastname"));

		registrationActions.enterEmail(TestDataReader.get("existingemail"));

		registrationActions.enterPassword(TestDataReader.get("password"));

		registrationActions.enterConfirmPassword(TestDataReader.get("confirmPassword"));

		logger.info("Existing user data entered successfully");
	}

	@And("the user clicks the {string} button")
	public void the_user_clicks_the_button(String button) {

		logger.info("User clicks button: " + button);

		if (button.equalsIgnoreCase("Register")) {

			registrationActions.clickRegisterButton();

			logger.info("Register button clicked successfully");
		}

		else if (button.equalsIgnoreCase("Continue")) {

			registrationActions.clickContinueButton();

			logger.info("Continue button clicked successfully");
		}
	}

	@Then("the page should display the message Your registration completed")
	public void the_page_should_display_the_message() {

		logger.info("Validating registration success message");

		Assert.assertEquals(registrationActions.getRegistrationSuccessMessage(),

				TestDataReader.get("successmessage"));

		logger.info("Registration success message validated successfully");
	}

	@Then("the email error message {string} should be displayed")
	public void the_email_error_message_should_be_displayed(String expectedMessage) {

		logger.info("Validating email error message");

		Assert.assertEquals(

				registrationActions.getEmailErrorMessage(),

				expectedMessage);

		logger.info("Email error message validated successfully");
	}

	@Then("the confirm password error message {string} should be displayed")
	public void the_confirm_password_error_message_should_be_displayed(String expectedMessage) {

		logger.info("Validating confirm password error message");

		Assert.assertEquals(registrationActions.getConfirmPasswordErrorMessage(),expectedMessage);

		logger.info("Confirm password error message validated successfully");
	}

	@Then("the page should display the error The specified email already exists")
	public void the_page_should_display_the_existing_email_error() {

		logger.info("Validating existing email error message");

		Assert.assertEquals(registrationActions.getExistingEmailErrorMessage(),TestDataReader.get("existingemailerror"));

		logger.info("Existing email error validated successfully");
	}

	@Then("the following validation messages should be displayed")
	public void the_following_validation_messages_should_be_displayed(DataTable dataTable) {

		logger.info("Validating mandatory field error messages");

		List<Map<String, String>> data =

				dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : data) {

			String field = row.get("Field");

			String expectedMessage = row.get("Message");

			logger.info("Validating field: " + field);

			switch (field) {

			case "FirstName":

				Assert.assertEquals(registrationActions.getFirstNameErrorMessage(),expectedMessage);

				logger.info("FirstName validation passed");

				break;

			case "LastName":

				Assert.assertEquals(registrationActions.getLastNameErrorMessage(),expectedMessage);

				logger.info("LastName validation passed");

				break;

			case "Email":

				Assert.assertEquals(registrationActions.getEmailErrorMessage(),expectedMessage);

				logger.info("Email validation passed");

				break;

			case "Password":

				Assert.assertEquals(registrationActions.getPasswordErrorMessage(),expectedMessage);

				logger.info("Password validation passed");

				break;
			}
		}

		logger.info("All validation messages verified successfully");
	}
}