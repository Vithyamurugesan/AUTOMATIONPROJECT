@SowndariyaNewsletter

Feature: Sowndariya_22MAY2025_DEMOWEBSHOP_Feature File For Newsletter Functionality

  Description:
  This feature is used to verify newsletter subscription functionality.

  Background:
    Given User opens Demo Web Shop homepage

  Scenario: Verify user can subscribe to newsletter
    Given User enters newsletter email from test data
    When User clicks on Subscribe button
    Then User should see newsletter subscription success message
