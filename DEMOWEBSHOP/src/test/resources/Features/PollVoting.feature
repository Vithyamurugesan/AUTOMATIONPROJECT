@Vithya

Feature: Vithya_07_JULY_2026_DEMOWEBSHOP_PollVoting

  Description:
    This feature verifies the poll voting functionality of the DemoWebShop application.
    It validates successful poll voting by a registered user,
    verifies that poll result percentages are displayed,
    and ensures guest users cannot vote in the poll.


  @Poll @VoteInPoll
  Scenario: Verify registered user can vote in a poll
    Given the user is logged in to the Demo Web Shop
    When the user selects the poll option
    And the user clicks the poll "Vote" button
    Then the page should display the poll voting result


  @Poll @ResultPercentage
  Scenario: Verify poll result percentage is displayed after voting
    Given the user is logged in to the Demo Web Shop
    When the user selects the poll option
    And the user clicks the poll "Vote" button
    Then the page should display the poll voting result
    And the poll result percentage should be displayed for all poll options


  @Poll @Guest
  Scenario: Verify guest user cannot vote in a poll
    Given the user is on the Demo Web Shop home page
    When the user selects the poll option
    And the user clicks the poll "Vote" button
    Then the page should display the message Only registered users can vote.