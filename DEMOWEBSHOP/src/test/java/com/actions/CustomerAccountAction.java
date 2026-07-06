package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.CustomerAccountPage;

public class CustomerAccountAction extends BaseAction {

    CustomerAccountPage cap;

    public CustomerAccountAction(WebDriver driver) {
        super(driver);
        cap = new CustomerAccountPage();
    }

    public void clickAccountLink() {
        click(cap.accountLink);
    }

    public void updateFirstName(String newName) {

        waitForVisibility(cap.firstNameInput);
        waitForVisibility(cap.firstNameInput).clear();
        type(cap.firstNameInput, newName);
    }

    public void clickSaveInfoButton() {
        click(cap.saveInfoButton);
    }

    public String getFirstNameValue() {
        return getValue(cap.firstNameInput);
    }
}