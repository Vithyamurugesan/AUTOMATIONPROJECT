Feature: Vithya_18MAY2026_DEMOWEBSHOP_FeatureFileforPromotions
  Description: As a user, I want to email a product to a friend
  so that I can share product details with others

  Background:
    Given user is logged in and on the laptop product page

  @RequiresLogin @EmailAFriend
  Scenario Outline: Verify recipient details fields on Email a friend form
    When user clicks on Email a friend button
    Then user should be on the Email a friend page
    And user enters friend email "<friendEmail>" and personal message "<message>"
    And user clicks Send email button
    Then "<expectedResult>" should be displayed

    Examples:
      | friendEmail            | message                  | expectedResult  |
      | testfriend@gmail.com   | Check out this laptop!   | success         |
      |                        |                          | error           |
