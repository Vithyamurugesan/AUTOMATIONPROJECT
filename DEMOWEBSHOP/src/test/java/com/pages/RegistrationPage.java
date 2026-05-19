package com.pages;

import org.openqa.selenium.By;

public class RegistrationPage {

    private By registerLink = By.linkText("Register");

    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");

    private By registerButton = By.id("register-button");
    private By continueButton = By.xpath("//input[@value='Continue']");

    private By registrationSuccessMessage = By.className("result");

    private By existingEmailError = By.xpath("//div[@class='validation-summary-errors']//li");

    private By firstNameError = By.xpath("//span[@data-valmsg-for='FirstName']");
    private By lastNameError = By.xpath("//span[@data-valmsg-for='LastName']");
    private By emailError = By.xpath("//span[@data-valmsg-for='Email']");
    private By passwordError = By.xpath("//span[@data-valmsg-for='Password']");
    private By confirmPasswordError = By.xpath("//span[@data-valmsg-for='ConfirmPassword']");

    public By getRegisterLink() {
        return registerLink;
    }

    public By getFirstNameField() {
        return firstNameField;
    }

    public By getLastNameField() {
        return lastNameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    public By getContinueButton() {
        return continueButton;
    }

    public By getRegistrationSuccessMessage() {
        return registrationSuccessMessage;
    }

    public By getExistingEmailError() {
        return existingEmailError;
    }

    public By getFirstNameError() {
        return firstNameError;
    }

    public By getLastNameError() {
        return lastNameError;
    }

    public By getEmailError() {
        return emailError;
    }

    public By getPasswordError() {
        return passwordError;
    }

    public By getConfirmPasswordError() {
        return confirmPasswordError;
    }
}