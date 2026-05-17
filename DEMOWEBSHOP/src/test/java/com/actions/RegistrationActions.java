package com.actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.RegistrationPage;

public class RegistrationActions extends BaseAction {

    private static final Logger log = LogManager.getLogger(RegistrationActions.class);

    WebDriver driver;
    WebDriverWait wait;
    RegistrationPage registrationPage;

    public RegistrationActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.registrationPage = new RegistrationPage();
    }

    public void clickRegisterLink() {
        click(registrationPage.getRegisterLink());
    }

    public void enterFirstName(String firstName) {
        type(registrationPage.getFirstNameField(), firstName);
    }

    public void enterLastName(String lastName) {
        type(registrationPage.getLastNameField(), lastName);
    }

    public void enterEmail(String email) {
        type(registrationPage.getEmailField(), email);
    }

    public void enterPassword(String password) {
        type(registrationPage.getPasswordField(), password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        type(registrationPage.getConfirmPasswordField(), confirmPassword);
    }

    public void clickRegisterButton() {
        click(registrationPage.getRegisterButton());
    }

    public void clickContinueButton() {
        WebElement continueBtn = waitForVisibility(registrationPage.getContinueButton());
        continueBtn.sendKeys(Keys.ENTER);
    }

    public String getSuccessMessage() {
        String message = getText(registrationPage.getRegistrationSuccessMessage());
        log.info("Registration success message: " + message);
        return message;
    }

    public String getExistingEmailErrorMessage() {
        String message = getText(registrationPage.getExistingEmailError());
        log.info("Existing email error: " + message);
        return message;
    }

    public String getFirstNameErrorMessage() {
        String message = getText(registrationPage.getFirstNameError());
        log.info("First name error: " + message);
        return message;
    }

    public String getLastNameErrorMessage() {
        String message = getText(registrationPage.getLastNameError());
        log.info("Last name error: " + message);
        return message;
    }

    public String getEmailErrorMessage() {
        String message = getText(registrationPage.getEmailError());
        log.info("Email error: " + message);
        return message;
    }

    public String getPasswordErrorMessage() {
        String message = getText(registrationPage.getPasswordError());
        log.info("Password error: " + message);
        return message;
    }

    public String getConfirmPasswordErrorMessage() {
        String message = getText(registrationPage.getConfirmPasswordError());
        log.info("Confirm password error: " + message);
        return message;
    }
}