Feature: Vithya_13MAY2026_DEMOWEBSHOP_User Registration Functionality

  Background:
    Given User is on Demo Web Shop application

  @ValidRegistration
  Scenario: Verify user registration with valid details
    Given User navigates to the Register page
    When  User enters valid registration details
    And   User clicks on Register button
    Then  User should be registered successfully
    And   User should see registration confirmation message


  @ExistingEmail
  Scenario: Verify registration with an already registered email
    Given User navigates to the Register page
    When  User enters registration details with an already registered email
    And   User clicks on Register button
    Then  User should see existing email error message
