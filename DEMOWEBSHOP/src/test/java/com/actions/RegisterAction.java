package com.actions;

import com.pages.RegisterPage;
import com.utilities.PropertyManager;

import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterAction {

	WebDriver driver;
	RegisterPage registerPage;

	public RegisterAction(WebDriver driver) {
		this.driver = driver;
		registerPage = new RegisterPage(driver);
	}

	private String generateUniqueEmail() {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		return "vithya_" + timestamp + "@testmail.com";
	}

	public void navigateToRegisterPage() {
		registerPage.clickRegisterLink();
	}

	public void enterFirstName(String firstName) {
		registerPage.enterFirstName(firstName);
	}

	public void enterLastName(String lastName) {
		registerPage.enterLastName(lastName);
	}

	public void enterEmail(String email) {
		registerPage.enterEmail(email);
	}

	public void enterUniqueEmail() {
		String uniqueEmail = generateUniqueEmail();
		System.out.println("Generated unique email: " + uniqueEmail);
		registerPage.enterEmail(uniqueEmail);
	}

	public void enterPassword(String password) {
		registerPage.enterPassword(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		registerPage.enterConfirmPassword(confirmPassword);
	}

	public void clickRegisterButton() {
		registerPage.clickRegisterButton();
	}

	public void enterValidRegistrationDetailsFromConfig() {
		enterFirstName(PropertyManager.getTestDataValue("register.valid.firstName"));
		enterLastName(PropertyManager.getTestDataValue("register.valid.lastName"));
		enterUniqueEmail();
		enterPassword(PropertyManager.getTestDataValue("register.valid.password"));
		enterConfirmPassword(PropertyManager.getTestDataValue("register.valid.confirmPassword"));
	}

	public void enterExistingEmailRegistrationFromConfig() {

		enterFirstName(PropertyManager.getTestDataValue("register.existing.firstName"));

		enterLastName(
				PropertyManager
						.getTestDataValue("register.existing.lastName"));

		enterEmail(
				PropertyManager
						.getTestDataValue("register.existing.email"));

		enterPassword(
				PropertyManager
						.getTestDataValue("register.existing.password"));

		enterConfirmPassword(
				PropertyManager
						.getTestDataValue(
								"register.existing.confirmPassword"));
	}

	public boolean isRegistrationSuccessful() {

		return registerPage.isSuccessMessageDisplayed();
	}

	public String getSuccessMessage() {

		return registerPage.getRegistrationSuccessMessage();
	}

	public boolean isExistingEmailErrorDisplayed() {

		return registerPage.isExistingEmailErrorDisplayed();
	}

	public String getExistingEmailErrorMessage() {

		return registerPage.getExistingEmailError();
	}

	public String getExpectedSuccessMessage() {
		return PropertyManager
				.getTestDataValue("register.success.message");
	}

	public String getExpectedExistingEmailKeyword() {

		return PropertyManager
				.getTestDataValue(
						"register.existing.error.keyword");
	}
}
