package com.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.PollVotingAction;
import com.utilities.HelperClass;
import com.utilities.TestDataReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PollVotingStepDefinition {

    private static final Logger logger =
            LogManager.getLogger(PollVotingStepDefinition.class);

    PollVotingAction pollVotingAction;


    @When("the user selects the poll option")
    public void the_user_selects_the_poll_option() {

        logger.info("Selecting poll option");

        pollVotingAction =
                new PollVotingAction(HelperClass.getDriver());

        String pollOption =
                TestDataReader.get("pollOption");

        logger.info("Poll option: " + pollOption);

        pollVotingAction.selectPollOption(pollOption);

        logger.info("Poll option selected successfully");
    }


    @And("the user clicks the poll {string} button")
    public void the_user_clicks_the_poll_button(String button) {

        logger.info("User clicks poll button: " + button);

        if (button.equalsIgnoreCase("Vote")) {

            pollVotingAction.clickVoteButton();

            logger.info("Vote button clicked successfully");
        }
    }


    @Then("the page should display the poll voting result")
    public void the_page_should_display_the_poll_voting_result() {

        logger.info("Validating poll voting result");

        Assert.assertTrue(
                pollVotingAction.isPollVotingResultDisplayed(),
                "Poll voting result is not displayed"
        );

        logger.info("Poll voting result displayed successfully");
    }


    @Then("the poll result percentage should be displayed for all poll options")
    public void the_poll_result_percentage_should_be_displayed_for_all_poll_options() {

        logger.info("Validating poll result percentages");

        Assert.assertTrue(
                pollVotingAction.arePollResultPercentagesDisplayed(),
                "Poll result percentages are not displayed"
        );

        logger.info("Poll result percentages displayed successfully");
    }


    @Then("the page should display the message Only registered users can vote.")
    public void the_page_should_display_the_message_only_registered_users_can_vote() {

        logger.info("Validating guest user poll voting error message");

        String actualMessage =
                pollVotingAction.getPollVoteErrorMessage();

        String expectedMessage =
                TestDataReader.get("pollGuestError");

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Guest user poll voting error message is incorrect"
        );

        logger.info(
                "Guest user voting restriction message validated successfully"
        );
    }
}