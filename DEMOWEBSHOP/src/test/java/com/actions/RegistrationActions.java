package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.RegistrationPage;
import com.utilities.ExcelReader;

public class RegistrationActions extends BaseAction {

    WebDriver driver;
    RegistrationPage registrationPage;

    public RegistrationActions(WebDriver driver) {

        super(driver);

        this.driver = driver;

        registrationPage = new RegistrationPage();
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

        type(registrationPage.getConfirmPasswordField(),
                confirmPassword);
    }

    public void clickRegisterButton() {

        click(registrationPage.getRegisterButton());
    }

    public void clickContinueButton() {

        click(registrationPage.getContinueButton());
    }

    public String getRegistrationSuccessMessage() {

        return getText(
                registrationPage.getRegistrationSuccessMessage());
    }

    public String getExistingEmailErrorMessage() {

        return getText(
                registrationPage.getExistingEmailError());
    }

    public String getFirstNameErrorMessage() {

        return getText(
                registrationPage.getFirstNameError());
    }

    public String getLastNameErrorMessage() {

        return getText(
                registrationPage.getLastNameError());
    }

    public String getEmailErrorMessage() {

        return getText(
                registrationPage.getEmailError());
    }

    public String getPasswordErrorMessage() {

        return getText(
                registrationPage.getPasswordError());
    }

    public String getConfirmPasswordErrorMessage() {

        return getText(
                registrationPage.getConfirmPasswordError());
    }
    public void enterRegistrationDetailsFromExcel(String path,String sheetName,int row) {

        enterFirstName(
                ExcelReader.getCellData(path, sheetName, row, 0));

        enterLastName(
                ExcelReader.getCellData(path, sheetName, row, 1));

        String email =
                ExcelReader.getCellData(path, sheetName, row, 2);

        String uniqueEmail =email.split("@")[0] + System.currentTimeMillis()+ "@gmail.com";
        enterEmail(uniqueEmail);


        enterPassword(
                ExcelReader.getCellData(path, sheetName, row, 3));

        enterConfirmPassword(
                ExcelReader.getCellData(path, sheetName, row, 4));
    }
}