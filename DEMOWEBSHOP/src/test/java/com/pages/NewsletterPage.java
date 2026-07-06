package com.pages;

import org.openqa.selenium.By;

public class NewsletterPage {

    private By newsletterEmail =
            By.id("newsletter-email");

    private By subscribeButton =
            By.id("newsletter-subscribe-button");

    private By subscriptionResult =
            By.id("newsletter-result-block");

    public By getNewsletterEmail() {
        return newsletterEmail;
    }

    public By getSubscribeButton() {
        return subscribeButton;
    }

    public By getSubscriptionResult() {
        return subscriptionResult;
    }

}