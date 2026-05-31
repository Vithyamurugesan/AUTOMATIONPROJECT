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
}