package com.pages;

import org.openqa.selenium.By;

public class EmailAFriendPage {


    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By loginButton = By.cssSelector("input[value='Log in']");

    private By emailAFriendButton = By.cssSelector("input.button-2[value='Email a friend']");


    private By friendEmailField = By.id("FriendEmail");
    private By personalMessageField = By.id("PersonalMessage");
    private By yourEmailDisplay = By.id("YourEmailAddress");
    private By sendEmailButton = By.cssSelector("input[value='Send email']");


    private By resultMessage = By.cssSelector(".result");


    private By friendEmailValidationError = By.cssSelector("span[data-valmsg-for='FriendEmail']");

    private By pageTitle = By.cssSelector("div.page-title h1");

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getEmailAFriendButton() {
        return emailAFriendButton;
    }

    public By getFriendEmailField() {
        return friendEmailField;
    }

    public By getPersonalMessageField() {
        return personalMessageField;
    }

    public By getYourEmailDisplay() {
        return yourEmailDisplay;
    }

    public By getSendEmailButton() {
        return sendEmailButton;
    }

    public By getResultMessage() {
        return resultMessage;
    }

    public By getFriendEmailValidationError() {
        return friendEmailValidationError;
    }

    public By getPageTitle() {
        return pageTitle;
    }
}