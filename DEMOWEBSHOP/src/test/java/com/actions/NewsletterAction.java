package com.actions;

import org.openqa.selenium.WebDriver;

import com.pages.NewsletterPage;

public class NewsletterAction extends BaseAction {

    NewsletterPage newsletterPage;

    public NewsletterAction(WebDriver driver) {
        super(driver);
        newsletterPage = new NewsletterPage();
    }

    public void enterNewsletterEmail(String email) {
        type(newsletterPage.getNewsletterEmail(), email == null ? "" : email);
    }

    public void clickSubscribeButton() {
        click(newsletterPage.getSubscribeButton());
    }

    public String getSubscriptionMessage() {
        return getText(newsletterPage.getSubscriptionResult());
    }

}