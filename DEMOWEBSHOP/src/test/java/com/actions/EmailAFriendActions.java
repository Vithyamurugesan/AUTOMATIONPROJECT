package com.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pages.EmailAFriendPage;

public class EmailAFriendActions extends BaseAction {

    private static final Logger log = LogManager.getLogger(EmailAFriendActions.class);

    private WebDriver driver;
    private EmailAFriendPage emailAFriendPage;

    public EmailAFriendActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.emailAFriendPage = new EmailAFriendPage();
    }

    public void doLogin(String email, String password) {
        log.info("Logging in with email: {}", email);
        waitForVisibility(emailAFriendPage.getEmailInput()).clear();
        type(emailAFriendPage.getEmailInput(), email);
        waitForVisibility(emailAFriendPage.getPasswordInput()).clear();
        type(emailAFriendPage.getPasswordInput(), password);
        click(emailAFriendPage.getLoginButton());
    }

    public void clickEmailAFriendButton() {
        log.info("Clicking Email a friend button on product page");
        click(emailAFriendPage.getEmailAFriendButton());
    }

    public boolean isEmailAFriendPageDisplayed() {
        try {
            String title = getText(emailAFriendPage.getPageTitle());
            boolean displayed = title.equalsIgnoreCase("Email a friend");
            log.info("Email a friend page displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Email a friend page title not found: {}", e.getMessage());
            return false;
        }
    }

    public void enterFriendEmail(String email) {
        log.info("Entering friend email: {}", email);
        waitForVisibility(emailAFriendPage.getFriendEmailField()).clear();
        type(emailAFriendPage.getFriendEmailField(), email);
    }

    public void enterPersonalMessage(String message) {
        log.info("Entering personal message");
        waitForVisibility(emailAFriendPage.getPersonalMessageField()).clear();
        type(emailAFriendPage.getPersonalMessageField(), message);
    }

    public void clickSendEmail() {
        log.info("Clicking Send email button");
        click(emailAFriendPage.getSendEmailButton());
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            String msg = getText(emailAFriendPage.getResultMessage());
            boolean success = msg != null && !msg.isEmpty();
            log.info("Success message displayed: {} | Message: {}", success, msg);
            return success;
        } catch (Exception e) {
            log.error("Success message not found: {}", e.getMessage());
            return false;
        }
    }

    public boolean isValidationErrorDisplayed() {
        try {
            boolean displayed = waitForVisibility(emailAFriendPage.getFriendEmailValidationError()).isDisplayed();
            log.info("Validation error displayed: {}", displayed);
            return displayed;
        } catch (Exception e) {
            log.error("Validation error element not found: {}", e.getMessage());
            return false;
        }
    }
}