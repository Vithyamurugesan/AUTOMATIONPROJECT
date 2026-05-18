Feature: Vithya_13MAY2025_DEMOWEBSHOP_Registration
  Description: As a new user, I want to register on the DemoWebShop
  so that I can access the website features

  Background:
    Given the user is on the DemoWebShop homepage

  @Registration @Smoke @Ignore 
  Scenario: Successful user registration with mandatory fields
    When the user clicks the "Register" link
    And the user fills in the mandatory registration details
      | Field            | Value                    |
      | First Name       | Vithya                   |
      | Last Name        | murugesan                |
      | Email            | vithyamurugesankmv@gmail.com|
      | Password         | 123456                   |
      | Confirm Password | 123456                   |
    And the user clicks the "Register" button
    Then the user should be redirected to the registration confirmation page
    And the page should display the message "Your registration completed"
    And the user clicks the "Continue" button

  @Registration @InvalidEmail
  Scenario: Verify registration with invalid email format
    When the user clicks the "Register" link
    And the user fills in the mandatory registration details
      | Field            | Value            |
      | First Name       | john             |
      | Last Name        | jack             |
      | Email            | john             |
      | Password         | 987456           |
      | Confirm Password | 987456           |
    And the user clicks the "Register" button
    Then the email error message "Wrong email" should be displayed

  @Registration @EmptyFields
  Scenario: Verify registration with empty mandatory fields
    When the user clicks the "Register" link
    And the user clicks the "Register" button
    Then the first name error message "First name is required." should be displayed
    And the last name error message "Last name is required." should be displayed
    And the email error message "Email is required." should be displayed
    And the password error message "Password is required." should be displayed

  @Registration @PasswordMismatch
  Scenario: Verify registration with password mismatch
    When the user clicks the "Register" link
    And the user fills in the mandatory registration details
      | Field            | Value                    |
      | First Name       | jessy                    |
      | Last Name        | Kumar                    |
      | Email            | jessy123456@gmail.com    |
      | Password         | jessy                    |
      | Confirm Password | jess                     |
    And the user clicks the "Register" button
    Then the confirm password error message "The password and confirmation password do not match." should be displayed

  @Registration @ExistingEmail @Ignore
  Scenario: Verify registration with existing email
    When the user clicks the "Register" link
    And the user fills in the mandatory registration details
      | Field            | Value                    |
      | First Name       | priya                    |
      | Last Name        | dev                      |
      | Email            |vithyamurugesankmv@gmail.com|
      | Password         | priyadev                 |
      | Confirm Password | priyadev                 |
    And the user clicks the "Register" button
    Then the page should display the error "The specified email already exists"
