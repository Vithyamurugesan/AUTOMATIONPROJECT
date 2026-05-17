package com.actions;

import com.pages.RegisterPage;
import com.utilities.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterAction {

    WebDriver driver;
    RegisterPage registerPage;

    public RegisterAction(WebDriver driver) {
		this.driver = driver;
        registerPage = new RegisterPage();
    }

    // -------------------- Utility --------------------

    private String generateUniqueEmail() {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return "vithya_" + timestamp + "@testmail.com";
    }

    // -------------------- Actions --------------------

    public void clickRegisterLink() {
        registerPage.wait.until(ExpectedConditions.elementToBeClickable(registerPage.registerLink));
        registerPage.registerLink.click();
    }

    public void enterFirstName(String firstName) {
        registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.firstNameField));
        registerPage.firstNameField.clear();
        registerPage.firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.lastNameField));
        registerPage.lastNameField.clear();
        registerPage.lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.emailField));
        registerPage.emailField.clear();
        registerPage.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.passwordField));
        registerPage.passwordField.clear();
        registerPage.passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.confirmPasswordField));
        registerPage.confirmPasswordField.clear();
        registerPage.confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        registerPage.wait.until(ExpectedConditions.elementToBeClickable(registerPage.registerButton));
        registerPage.registerButton.click();
    }

    public void navigateToRegisterPage() {
        clickRegisterLink();
    }

    public void enterValidRegistrationDetailsFromConfig() {
        enterFirstName(ConfigReader.get("register.valid.firstName"));
        enterLastName(ConfigReader.get("register.valid.lastName"));
        enterEmail(generateUniqueEmail());
        enterPassword(ConfigReader.get("register.valid.password"));
        enterConfirmPassword(ConfigReader.get("register.valid.confirmPassword"));
    }

    public String getSuccessMessage() {
        try {
            registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.registrationSuccessMessage));
            return registerPage.registrationSuccessMessage.getText().trim();
        } catch (Exception e) {
            System.out.println("Could not retrieve success message: " + e.getMessage());
            return "";
        }
    }

    public boolean isContinueButtonDisplayed() {
        try {
            registerPage.wait.until(ExpectedConditions.visibilityOf(registerPage.continueButton));
            return registerPage.continueButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Continue button not found: " + e.getMessage());
            return false;
        }
    }

    public String getExpectedSuccessMessage() {
        return ConfigReader.get("register.success.message");
    }
}