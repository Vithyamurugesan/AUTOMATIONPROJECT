package com.stepdefinitions;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.actions.LoginAction;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;
import com.utilities.LoginTestData;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

	LoginAction logaction;

	WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(LoginStepDefinition.class);
	@Given("the user is on the Demo Web Shop login page")
	public void the_user_is_on_the_demo_web_shop_login_page() {
		log.info("Launching Demo Web Shop login page");
		driver = HelperClass.getDriver();
		driver.get(ConfigReader.get("app.url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		logaction = new LoginAction(driver);
	}

	@When("user clicks loginlink")
	public void user_clicks_loginlink() {
		log.info("Clicking login link");
		logaction.clicklogin();
	}

	@When("the user enters a registered email")
	public void the_user_enters_a_registered_email() {
		log.info("Entering registered email");
		logaction.userEmail(LoginTestData.email);
	}

	@When("the user enters a valid password")
	public void the_user_enters_a_valid_password() {
		log.info("Entering valid password");
		logaction.userPassword(LoginTestData.password);
	}

	@When("the user clicks the Log in button")
	public void the_user_clicks_the_log_in_button() {
		log.info("Clicking login button");
		logaction.clickloginbtn();
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() {
		log.info("Verifying homepage redirection");
		Assert.assertTrue(driver.getCurrentUrl().contains("demowebshop"));
	}

	@Then("the logged-in user email should be displayed in the header")
	public void the_logged_in_user_email_should_be_displayed_in_the_header() {
		log.info("Verifying logged in user email");
		String actual = logaction.loggedUser();
		Assert.assertEquals(actual, "haritha11@gmail.com");
	}

	@Then("the Log out link should be visible")
	public void the_log_out_link_should_be_visible() {

		Assert.assertTrue(logaction.logout());
	}

	@When("the user enters the email {string}")
	public void the_user_enters_the_email(String email) {

		logaction.userEmail(email);
	}

	@When("the user enters the password {string}")
	public void the_user_enters_the_password(String password) {

		logaction.userPassword(password);
	}

	@Then("an error message {string} should be displayed")
	public void an_error_message_should_be_displayed(String message) {

		String actualMessage = logaction.getLoginErrorMessage();

		System.out.println("Actual Message: " + actualMessage);

		Assert.assertTrue(actualMessage.contains(message));
	}

	@Then("the user should remain on the login page")
	public void the_user_should_remain_on_the_login_page() {

		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	@Given("the Forgot password? link is visible")
	public void the_forgot_password_link_is_visible() {

		Assert.assertTrue(logaction.waitForVisibility(LoginPage.getForgotpasswordlink()).isDisplayed());
	}

	@When("the user clicks the Forgot password? link")
	public void the_user_clicks_the_forgot_password_link() {

		logaction.forgotpasswordclick();
	}

	@Then("the user should be redirected to the password recovery page")
	public void the_user_should_be_redirected_to_the_password_recovery_page() {

		Assert.assertTrue(driver.getCurrentUrl().contains("passwordrecovery"));
	}

	@Then("the page title should display {string}")
	public void the_page_title_should_display(String title) {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.toLowerCase().contains(title.toLowerCase()));
	}

	@Then("the Email input field should be visible")
	public void the_email_input_field_should_be_visible() {

		Assert.assertTrue(logaction.waitForVisibility(LoginPage.getRecoveryemail()).isDisplayed());
	}

	@Given("the user is on the Password Recovery page")
	public void the_user_is_on_the_password_recovery_page() {

		driver = HelperClass.getDriver();
		driver.get(ConfigReader.get("recovery.url"));
		logaction = new LoginAction(driver);
	}

	@When("the user enters a recovery email {string}")
	public void the_user_enters_a_recovery_email(String email) {
		if (!email.isEmpty()) {
			logaction.recoveryEmail(email);
		}
	}

	@When("the user clicks the Recover button")
	public void the_user_clicks_the_recover_button() {
		logaction.recoverbutton();
	}

	@Then("the system should display recovery message {string}")
	public void the_system_should_display_recovery_message(String message) {

		String actualMessage;

		if (message.equals("Email with instructions has been sent to you.")) {
			actualMessage = logaction.getRecoverySuccessMessage();

		} else {
			actualMessage = logaction.getValidationMessage();
		}
		System.out.println("Actual Message: " + actualMessage);
		Assert.assertTrue(actualMessage.contains(message));
	}
	
}