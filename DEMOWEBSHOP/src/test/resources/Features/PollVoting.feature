@Vithya

Feature: Vithya_07_JULY_2026_DEMOWEBSHOP_PollVoting

  Description:
    This feature verifies the poll voting functionality of the DemoWebShop application.
    It validates successful poll voting by a registered user,
    verifies that poll result percentages are displayed,
    and ensures guest users cannot vote in the poll.


  @Poll @VoteInPoll
  Scenario: Verify registered user can vote in a poll

    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email
    And the user enters a valid password
    And the user clicks the Log in button

    When the user selects the poll option
    And the user clicks the poll "Vote" button

    Then the page should display the poll voting result


  @Poll @ResultPercentage
  Scenario: Verify poll result percentage is displayed after voting

    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email
    And the user enters a valid password
    And the user clicks the Log in button

    When the user selects the poll option
    And the user clicks the poll "Vote" button

    Then the poll result percentage should be displayed for all poll options


  @Poll @GuestUser
  Scenario: Verify guest user cannot vote in a poll

    Given the user is on the DemoWebShop homepage

    When the user selects the poll option
    And the user clicks the poll "Vote" button

    Then the page should display the message Only registered users can vote.