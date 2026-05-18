package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;

public class LoginAction extends BaseAction {

    WebDriver driver;

    public LoginAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clicklogin() {

        click(LoginPage.loginLink);
    }

    public void userEmail(String userEmail) {

        type(LoginPage.email, userEmail);
    }

    public void userPassword(String userPassword) {

        type(LoginPage.password, userPassword);
    }

    public void clickloginbtn() {

        click(LoginPage.loginbtn);
    }

    public String loggedUser() {

        return getText(LoginPage.useraccountname);
    }

    public boolean logout() {

        return waitForVisibility(LoginPage.logoutLink).isDisplayed();
    }

    public void forgotpasswordclick() {

        click(LoginPage.forgotpasswordlink);
    }

    public void recoveryEmail(String email) {

        type(LoginPage.recoveryemail, email);
    }

    public void recoverbutton() {

        click(LoginPage.recoverbtn);
    }

    public String getLoginErrorMessage() {

        return getText(LoginPage.loginErrorMessage);
    }

    public String getRecoverySuccessMessage() {

        return getText(LoginPage.recoverySuccessMessage);
    }

    public String getValidationMessage() {

        return getText(LoginPage.validationMessage);
    }
}