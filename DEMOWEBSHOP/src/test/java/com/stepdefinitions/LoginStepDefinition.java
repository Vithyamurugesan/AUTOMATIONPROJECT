package com.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.LoginAction;
import com.pages.LoginPageLocator;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

	LoginAction logaction;

	LoginPageLocator login;

	WebDriverWait wait;

	@Given("the user is on the Demo Web Shop login page")
	public void the_user_is_on_the_demo_web_shop_login_page() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		logaction = new LoginAction(driver);

		login = new LoginPageLocator(driver);
	}

	@When("user clicks loginlink")
	public void user_clicks_loginlink() {
		logaction.clicklogin();
	}
	@When("the user enters a registered email {string}")
	public void the_user_enters_a_registered_email(String email) {

		logaction.userEmail(email);
	}

	@When("the user enters a valid password {string}")
	public void the_user_enters_a_valid_password(String password) {

		logaction.userPassword(password);
	}

	@When("the user clicks the Log in button")
	public void the_user_clicks_the_log_in_button() {

		logaction.clickloginbtn();
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() {

		logaction.waitforhomepage(wait);

		Assert.assertTrue(driver.getCurrentUrl().contains("demowebshop"));
	}

	@Then("the logged-in user email should be displayed in the header")
	public void the_logged_in_user_email_should_be_displayed_in_the_header() {

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

	    String actualMessage = login.loginErrorMessage.getText();

	    System.out.println("Actual Message: " + actualMessage);

	    Assert.assertTrue(actualMessage.contains(message));
	}

	@Then("the user should remain on the login page")
	public void the_user_should_remain_on_the_login_page() {

		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	@Given("the Forgot password? link is visible")
	public void the_forgot_password_link_is_visible() {

		Assert.assertTrue(login.forgotpasswordlink.isDisplayed());
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

	    Assert.assertTrue(actualTitle.toLowerCase()
	            .contains(title.toLowerCase()));
	}

	@Then("the Email input field should be visible")
	public void the_email_input_field_should_be_visible() {

		Assert.assertTrue(login.recoveryemail.isDisplayed());
	}

	@Given("the user is on the Password Recovery page")
	public void the_user_is_on_the_password_recovery_page() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/passwordrecovery");

		logaction = new LoginAction(driver);

		login = new LoginPageLocator(driver);
	}

	@When("the user enters a recovery email {string}")
	public void the_user_enters_a_recovery_email(String email) {

		logaction.recoveryEmail(email);
	}

	@When("the user clicks the Recover button")
	public void the_user_clicks_the_recover_button() {

		logaction.recoverbutton();
	}

	@Then("a success message {string} should be displayed")
	public void a_success_message_should_be_displayed(String message) {

		String actual = logaction.getRecoverySuccessMessage();

		Assert.assertEquals(actual, message);
	}

	@When("the user enters an invalid email {string}")
	public void the_user_enters_an_invalid_email(String email) {

		logaction.recoveryEmail(email);
	}

	@Then("the system should display an error message {string}")
	public void the_system_should_display_an_error_message(String message) {

		String actual = logaction.getValidationMessage();

		Assert.assertTrue(actual.contains(message));
	}

	@When("the user clicks the Recover button without entering an email")
	public void the_user_clicks_the_recover_button_without_entering_an_email() {

		logaction.recoverbutton();
	}

	@Then("a validation message {string} should be displayed")
	public void a_validation_message_should_be_displayed(String message) {

		String actual = logaction.getValidationMessage();

		Assert.assertTrue(actual.contains(message));
	}

	@Then("the user should remain on the Password Recovery page")
	public void the_user_should_remain_on_the_password_recovery_page() {

		Assert.assertTrue(driver.getCurrentUrl().contains("passwordrecovery"));
	}

	@After
	public void tearDown() {

		driver.quit();
	}
}