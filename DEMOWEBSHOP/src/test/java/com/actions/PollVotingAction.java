package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.PollVotingPage;

public class PollVotingAction extends BaseAction {

    PollVotingPage pollVotingPage;

    public PollVotingAction(WebDriver driver) {
        super(driver);
        pollVotingPage = new PollVotingPage();
    }


    public void selectPollOption(String pollOption) {
        By option = pollVotingPage.getPollOption(pollOption);
        click(option);
    }


    public void clickVoteButton() {
        click(pollVotingPage.getPollVoteButton());
    }


    public boolean isPollVotingResultDisplayed() {
        try {
            return waitForVisibility(pollVotingPage.getPollVotingResult()).isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean arePollResultPercentagesDisplayed() {

        try {

            return driver.findElements(
                    pollVotingPage.getPollResultPercentages()
            ).size() == 4;

        }
        catch (Exception e) {

            return false;
        }
    }

  
    public String getPollVoteErrorMessage() {
        return getText(pollVotingPage.getPollVoteError());
    }
}