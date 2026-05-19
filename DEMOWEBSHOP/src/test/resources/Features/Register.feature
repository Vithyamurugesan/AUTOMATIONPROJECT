Feature: Vithya_13MAY2025_DEMOWEBSHOP_Registration
  Background:
    Given the user is on the DemoWebShop homepage
    When the user clicks the "Register" link


  @Registration @ValidRegistration
  Scenario: Verify successful user registration using excel data

    And the user enters registration details from excel row "1"
    And the user clicks the "Register" button

    Then the page should display the message Your registration completed



  @Registration @InvalidEmail
  Scenario Outline: Verify registration with invalid email format

    And the user enters firstname "<firstname>"
    And the user enters lastname "<lastname>"
    And the user enters email "<email>"
    And the user enters password "<password>"
    And the user enters confirm password "<confirmPassword>"
    And the user clicks the "Register" button

    Then the email error message "<errorMessage>" should be displayed

    Examples:
      | firstname | lastname | email | password | confirmPassword | errorMessage |
      | john      | jack     | john  | 123456   | 123456          | Wrong email  |
      | jen       | jeck     | jen   | 987456   | 987456          | Wrong email  |



  @Registration @EmptyFields
  Scenario: Verify registration with empty mandatory fields

    And the user clicks the "Register" button

    Then the following validation messages should be displayed

      | Field      | Message                    |
      | FirstName  | First name is required.    |
      | LastName   | Last name is required.     |
      | Email      | Email is required.         |
      | Password   | Password is required.      |



  @Registration @PasswordMismatch
  Scenario Outline: Verify registration with password mismatch

    And the user enters firstname "<firstname>"
    And the user enters lastname "<lastname>"
    And the user enters email "<email>"
    And the user enters password "<password>"
    And the user enters confirm password "<confirmPassword>"
    And the user clicks the "Register" button

    Then the confirm password error message "<errorMessage>" should be displayed

    Examples:
      | firstname | lastname | email                  | password | confirmPassword | errorMessage                                         |
      | jessy     | kumar    | jessy123@gmail.com     | abc123   | abc12           | The password and confirmation password do not match. |
      | priya     | dev      | priya123@gmail.com     | dev123   | dev12           | The password and confirmation password do not match. |



  @Registration @ExistingEmail
  Scenario: Verify registration with existing email using properties file

    And the user enters existing user data from properties file
    And the user clicks the "Register" button

    Then the page should display the error The specified email already exists