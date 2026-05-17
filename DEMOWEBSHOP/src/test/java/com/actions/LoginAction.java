package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPageLocator;

public class LoginAction extends BaseAction {

    WebDriver driver;

    public LoginAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clicklogin() {

        click(LoginPageLocator.loginLink);
    }

    public void userEmail(String userEmail) {

        type(LoginPageLocator.email, userEmail);
    }

    public void userPassword(String userPassword) {

        type(LoginPageLocator.password, userPassword);
    }

    public void clickloginbtn() {

        click(LoginPageLocator.loginbtn);
    }

    public String loggedUser() {

        return getText(LoginPageLocator.useraccountname);
    }

    public boolean logout() {

        return waitForVisibility(LoginPageLocator.logoutLink).isDisplayed();
    }

    public void forgotpasswordclick() {

        click(LoginPageLocator.forgotpasswordlink);
    }

    public void recoveryEmail(String email) {

        type(LoginPageLocator.recoveryemail, email);
    }

    public void recoverbutton() {

        click(LoginPageLocator.recoverbtn);
    }

    public String getLoginErrorMessage() {

        return getText(LoginPageLocator.loginErrorMessage);
    }

    public String getRecoverySuccessMessage() {

        return getText(LoginPageLocator.recoverySuccessMessage);
    }

    public String getValidationMessage() {

        return getText(LoginPageLocator.validationMessage);
    }
}