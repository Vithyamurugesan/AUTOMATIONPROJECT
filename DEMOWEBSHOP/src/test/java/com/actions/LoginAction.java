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

        click(LoginPage.getLoginLink());
    }

    public void userEmail(String userEmail) {

        type(LoginPage.getEmail(), userEmail);
    }

    public void userPassword(String userPassword) {

        type(LoginPage.getPassword(), userPassword);
    }

    public void clickloginbtn() {

        click(LoginPage.getLoginbtn());
    }

    public String loggedUser() {

        return getText(LoginPage.getUseraccountname());
    }

    public boolean logout() {

        return waitForVisibility(LoginPage.getLogoutLink()).isDisplayed();
    }

    public void forgotpasswordclick() {

        click(LoginPage.getForgotpasswordlink());
    }

    public void recoveryEmail(String email) {

        type(LoginPage.getRecoveryemail(), email);
    }

    public void recoverbutton() {

        click(LoginPage.getRecoverbtn());
    }

    public String getLoginErrorMessage() {

        return getText(LoginPage.getLoginErrorMessage());
    }

    public String getRecoverySuccessMessage() {

        return getText(LoginPage.getRecoverySuccessMessage());
    }

    public String getValidationMessage() {

        return getText(LoginPage.getValidationMessage());
    }
}