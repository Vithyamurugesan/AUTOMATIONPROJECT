package com.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.AddressPage;

public class AddressAction extends BaseAction {

    AddressPage addressPage;

    public AddressAction(WebDriver driver) {
        super(driver);
        addressPage = new AddressPage();
    }

    public void clickAddNewButton() {
        click(addressPage.getAddNewButton());
    }

    public void enterFirstName(String value) {
        type(addressPage.getFirstName(), value == null ? "" : value);
    }

    public void enterLastName(String value) {
        type(addressPage.getLastName(), value == null ? "" : value);
    }

    public void enterEmail(String value) {
        type(addressPage.getEmail(), value == null ? "" : value);
    }

    public void enterCompany(String value) {
        type(addressPage.getCompany(), value == null ? "" : value);
    }

    public void selectCountry(String value) {

        if (value != null && !value.trim().isEmpty()) {
            select(addressPage.getCountry(), value);
        }
    }

    public void selectState(String value) {

        if (value != null && !value.trim().isEmpty()) {
            select(addressPage.getState(), value);
        }
    }

    public void enterCity(String value) {
        type(addressPage.getCity(), value == null ? "" : value);
    }

    public void enterAddress1(String value) {
        type(addressPage.getAddress1(), value == null ? "" : value);
    }

    public void enterAddress2(String value) {
        type(addressPage.getAddress2(), value == null ? "" : value);
    }

    public void enterPostalCode(String value) {
        type(addressPage.getPostalCode(), value == null ? "" : value);
    }

    public void enterPhone(String value) {
        type(addressPage.getPhone(), value == null ? "" : value);
    }

    public void enterFax(String value) {
        type(addressPage.getFaxNumber(), value == null ? "" : value);
    }

    public void clickSave() {
        click(addressPage.getSave());
    }

    public List<WebElement> getValidationMessages() {
        return driver.findElements(addressPage.getValidationMessages());
    }

    public List<WebElement> getAddressCards() {
        return driver.findElements(addressPage.getAddressCards());
    }
}