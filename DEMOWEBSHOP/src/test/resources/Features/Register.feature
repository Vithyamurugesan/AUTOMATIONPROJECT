Feature: Vithya_13MAY2026_DEMOWEBSHOP_User Registration Functionality

  Background:
    Given User is on Demo Web Shop application

	
  @ValidRegistration @Ignore
  Scenario: Verify user registration with valid details
    Given User navigates to the Register page
    When  User enters valid registration details
    And   User clicks on Register button
    Then  User should see "Your registration completed" message
    And   User should see Continue button