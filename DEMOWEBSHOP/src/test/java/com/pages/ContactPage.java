package com.pages;

import org.openqa.selenium.By;

public class ContactPage {

    private static By contactLink =
            By.xpath("//div[@class='column information']/child::ul/li/a[text()='Contact us']");

    private static By emailField = By.id("Email");

    private static By nameField = By.id("FullName");

    private static By enquiryField = By.id("Enquiry");

    private static By submitButton =
            By.xpath("//input[@value='Submit']");

    private static By successMessage =
            By.xpath("//div[contains(@class,'result')]");

    private static By validationError =
            By.xpath("//span[contains(@class,'field-validation-error')]");


    public static By getContactLink() {
        return contactLink;
    }

    public static By getEmailField() {
        return emailField;
    }

    public static By getNameField() {
        return nameField;
    }

    public static By getEnquiryField() {
        return enquiryField;
    }

    public static By getSubmitButton() {
        return submitButton;
    }

    public static By getSuccessMessage() {
        return successMessage;
    }

    public static By getValidationError() {
        return validationError;
    }
}