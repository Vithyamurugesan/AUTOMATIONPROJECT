package com.pages;

import org.openqa.selenium.By;

public class PollVotingPage {

    private By loginLink = By.xpath("//a[contains(@class,'ico-login')]");

    private By pollOptionExcellent =
            By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Excellent']");

    private By pollOptionGood =
            By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Good']");

    private By pollOptionPoor =
            By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Poor']");

    private By pollOptionVeryBad =
            By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Very bad']");

    private By pollVoteButton =
            By.xpath("//div[@id='poll-block-1']//input[@value='Vote']");

    private By pollVotingResult =
            By.xpath("//div[@id='poll-block-1']//div[contains(@class,'poll-results')]");

    private By pollResultPercentages =
            By.xpath("//div[@id='poll-block-1']//*[contains(text(),'%')]");

    private By pollVoteError =
            By.xpath("//div[@id='poll-block-1']//div[contains(@id,'block-poll-vote-error')]");


    public By getLoginLink() {
        return loginLink;
    }

    public By getPollVoteButton() {
        return pollVoteButton;
    }

    public By getPollVotingResult() {
        return pollVotingResult;
    }

    public By getPollResultPercentages() {
        return pollResultPercentages;
    }

    public By getPollVoteError() {
        return pollVoteError;
    }

    public By getPollOption(String pollOption) {
        return By.xpath(
            "//div[@id='poll-block-1']//label[normalize-space()='" + pollOption + "']"
        );
    }
}