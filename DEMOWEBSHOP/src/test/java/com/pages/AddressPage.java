package com.pages;

import org.openqa.selenium.By;

public class AddressPage {

    private By firstName = By.id("Address_FirstName");
    private By lastName = By.id("Address_LastName");
    private By email = By.id("Address_Email");
    private By company = By.id("Address_Company");
    private By country = By.id("Address_CountryId");
    private By state = By.id("Address_StateProvinceId");
    private By city = By.id("Address_City");
    private By address1 = By.id("Address_Address1");
    private By address2 = By.id("Address_Address2");
    private By postalCode = By.id("Address_ZipPostalCode");
    private By phone = By.id("Address_PhoneNumber");
    private By faxNumber = By.id("Address_FaxNumber");

    private By save =
            By.cssSelector("input.button-1.save-address-button");

    private By addNewButton =
            By.cssSelector("input.button-1.add-address-button");

    private By validationMessages =
            By.cssSelector("span.field-validation-error");

    private By addressCards =
            By.cssSelector("div.section.address-item");

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getEmail() {
        return email;
    }

    public By getCompany() {
        return company;
    }

    public By getCountry() {
        return country;
    }

    public By getState() {
        return state;
    }

    public By getCity() {
        return city;
    }

    public By getAddress1() {
        return address1;
    }

    public By getAddress2() {
        return address2;
    }

    public By getPostalCode() {
        return postalCode;
    }

    public By getPhone() {
        return phone;
    }

    public By getFaxNumber() {
        return faxNumber;
    }

    public By getSave() {
        return save;
    }

    public By getAddNewButton() {
        return addNewButton;
    }

    public By getValidationMessages() {
        return validationMessages;
    }

    public By getAddressCards() {
        return addressCards;
    }
}