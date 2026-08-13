package com.pages;

import org.openqa.selenium.By;

public class PollVotingPage {

    private By pollOptionExcellent =By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Excellent']");

    private By pollOptionGood =By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Good']");

    private By pollOptionPoor = By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Poor']");

    private By pollOptionVeryBad = By.xpath("//div[@id='poll-block-1']//label[normalize-space()='Very bad']");


    private By pollVoteButton =
            By.xpath("//div[@id='poll-block-1']//input[@value='Vote']");


    private By pollVotingResult =By.xpath("//div[@id='poll-block-1']//ul[contains(@class,'poll-results')]");



    private By pollResultPercentages =By.xpath("//div[@id='poll-block-1']//ul[contains(@class,'poll-results')]/li[contains(@class,'answer')]");


    private By pollVoteError =By.xpath("//div[@id='poll-block-1']//div[contains(@id,'block-poll-vote-error')]");


    public By getPollOptionExcellent() {
        return pollOptionExcellent;
    }

    public By getPollOptionGood() {
        return pollOptionGood;
    }

    public By getPollOptionPoor() {
        return pollOptionPoor;
    }

    public By getPollOptionVeryBad() {
        return pollOptionVeryBad;
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
                "//div[@id='poll-block-1']//label[normalize-space()='"
                + pollOption
                + "']"
        );
    }
}