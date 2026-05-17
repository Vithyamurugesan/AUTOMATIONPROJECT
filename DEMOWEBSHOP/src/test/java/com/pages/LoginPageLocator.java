package com.pages;

import org.openqa.selenium.By;

public class LoginPageLocator {

    public static By loginLink = By.cssSelector(".ico-login");
    public static By email = By.id("Email");
    public static By password = By.id("Password");
    public static By loginbtn = By.cssSelector("input[value='Log in']");
    public static By useraccountname = By.cssSelector(".header-links .account");
    public static By logoutLink = By.cssSelector(".ico-logout");
    public static By forgotpasswordlink = By.linkText("Forgot password?");
    public static By recoveryemail = By.id("Email");
    public static By recoverbtn = By.cssSelector("input[value='Recover']");
    public static By loginErrorMessage = By.cssSelector(".validation-summary-errors");
    public static By recoverySuccessMessage = By.cssSelector(".result");
    public static By validationMessage = By.cssSelector(".field-validation-error");

}