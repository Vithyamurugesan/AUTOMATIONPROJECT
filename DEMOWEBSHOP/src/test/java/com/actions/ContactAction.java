package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.ContactPage;

public class ContactAction extends BaseAction {

    WebDriver driver;

    public ContactAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void waitforContactLink() {
        waitForVisibility(ContactPage.getContactLink());
    }

    public void clickContact() {
        click(ContactPage.getContactLink());
    }

    public String getNameValue() {
        return getValue(ContactPage.getNameField());
    }

    public String getEmailValue() {
        return getValue(ContactPage.getEmailField());
    }

    // New methods for Scenario 3 and Scenario 4

    public void enterEnquiryDetails(String enquiry) {
        type(ContactPage.getEnquiryField(), enquiry);
    }

    public void clickSubmit() {
        click(ContactPage.getSubmitButton());
    }

    public String getSuccessMessage() {
        return getText(ContactPage.getSuccessMessage());
    }

    public String getValidationError() {
        return getText(ContactPage.getValidationError());
    }
}