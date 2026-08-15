package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.PollVotingPage;
import com.utilities.ConfigReader;

public class PollVotingAction extends BaseAction {

    PollVotingPage pollVotingPage;

    public PollVotingAction(WebDriver driver) {
        super(driver);
        pollVotingPage = new PollVotingPage();
    }

    public void loginRegisteredUser() {

        // Open Demo Web Shop home page using config.properties URL
        driver.get(ConfigReader.get("app.url"));

        // Click Login
        click(pollVotingPage.getLoginLink());

        // Continue with your existing login code here
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
            return waitForVisibility(
                    pollVotingPage.getPollVotingResult()
            ).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean arePollResultPercentagesDisplayed() {

        try {
            return !driver.findElements(
                    pollVotingPage.getPollResultPercentages()
            ).isEmpty();

        } catch (Exception e) {
            return false;
        }
    }

    public String getPollVoteErrorMessage() {

        return getText(pollVotingPage.getPollVoteError());
    }
}