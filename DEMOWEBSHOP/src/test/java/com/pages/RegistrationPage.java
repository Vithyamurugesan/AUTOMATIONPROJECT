package com.pages;

import org.openqa.selenium.By;

public class RegistrationPage {

    private By registerLink =By.xpath("//a[contains(@class,'ico-register')]");

    private By firstNameField = By.xpath("//label[text()='First name:']/following::input[@id='FirstName']");

    private By lastNameField = By.xpath("//label[text()='Last name:']/following::input[@id='LastName']");

    private By emailField = By.xpath("//label[text()='Email:']/following::input[@id='Email']");
  
    private By passwordField =By.xpath("//label[text()='Password:']/following::input[@id='Password']");

    private By confirmPasswordField = By.xpath("//label[text()='Confirm password:']/following::input[@id='ConfirmPassword']");

    private By registerButton = By.xpath("//div[@class='buttons']/descendant::input[@id='register-button']");

    private By continueButton = By.xpath("//div[@class='buttons']/descendant::input[@value='Continue']");
   
    private By registrationSuccessMessage =By.xpath("//div[@class='result']");

    private By existingEmailError =By.xpath("//div[@class='validation-summary-errors']/descendant::li");

    private By firstNameError =  By.xpath("//span[@for='FirstName']");

    private By lastNameError =By.xpath("//span[@for='LastName']");

    private By emailError =By.xpath("//span[@for='Email']");

    private By passwordError = By.xpath("//span[@for='Password']");

    private By confirmPasswordError = By.xpath("//span[@for='ConfirmPassword']");

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