@Vithya
Feature: Vithya_07_JULY_2026_DEMOWEBSHOP_PollVoting

  Description:
  This feature verifies the poll voting functionality of the DemoWebShop application.
  It validates successful poll voting by a registered user,
  verifies that poll result percentages are displayed,
  and ensures guest users cannot vote in the poll.

  @Poll @VoteInPoll
  Scenario Outline: Verify registered user can vote in a poll

    Given the user is on the DemoWebShop homepage
    And the user logs in using valid credentials from properties file

    When the user selects the poll option "<pollOption>"
    And the user clicks the "Vote" button

    Then the page should display the poll voting result

    Examples:
      | pollOption |
      | Excellent  |
      | Good       |
      | Poor       |



  @Poll @ResultPercentage
  Scenario Outline: Verify poll result percentage is displayed after voting

    Given the user is on the DemoWebShop homepage
    And the user logs in using valid credentials from properties file

    When the user selects the poll option "<pollOption>"
    And the user clicks the "Vote" button

    Then the poll result percentage should be displayed for all poll options

    Examples:
      | pollOption |
      | Excellent  |



  @Poll @GuestUser
  Scenario Outline: Verify guest user cannot vote in a poll

    Given the user is on the DemoWebShop homepage

    When the user selects the poll option "<pollOption>"
    And the user clicks the "Vote" button

    Then the page should display the message Only registered users can vote.

    Examples:
      | pollOption |
      | Excellent  |