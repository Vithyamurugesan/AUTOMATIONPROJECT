package com.pages;

import org.openqa.selenium.By;

public class LoginPage {

    private static By loginLink = By.cssSelector(".ico-login");
    private static By email = By.id("Email");
    private static By password = By.id("Password");
    private static By loginbtn = By.cssSelector("input[value='Log in']");
    private static By useraccountname = By.cssSelector(".header-links .account");
    private static By logoutLink = By.cssSelector(".ico-logout");
    private static By forgotpasswordlink = By.linkText("Forgot password?");
    private static By recoveryemail = By.id("Email");
    private static By recoverbtn = By.cssSelector("input[value='Recover']");
    private static By loginErrorMessage = By.cssSelector(".validation-summary-errors");
    private static By recoverySuccessMessage = By.cssSelector(".result");
    private static By validationMessage = By.cssSelector(".field-validation-error");

    
    public static By getLoginLink() {
        return loginLink;
    }

    public static By getEmail() {
        return email;
    }

    public static By getPassword() {
        return password;
    }

    public static By getLoginbtn() {
        return loginbtn;
    }

    public static By getUseraccountname() {
        return useraccountname;
    }

    public static By getLogoutLink() {
        return logoutLink;
    }

    public static By getForgotpasswordlink() {
        return forgotpasswordlink;
    }

    public static By getRecoveryemail() {
        return recoveryemail;
    }

    public static By getRecoverbtn() {
        return recoverbtn;
    }

    public static By getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public static By getRecoverySuccessMessage() {
        return recoverySuccessMessage;
    }

    public static By getValidationMessage() {
        return validationMessage;
    }
}