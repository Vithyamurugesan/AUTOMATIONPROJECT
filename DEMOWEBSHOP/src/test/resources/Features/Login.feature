Feature: Haritha-Login and Password Recovery in Demo Web Shop

  @login @smoke @positive
  Scenario: Successful login with valid credentials

    Given the user navigates to the Demo Web Shop login page
    When the user enters a registered email address
    And the user enters a valid password
    And the user clicks the "Log in" button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    And the "Log out" link should be visible


  @login @negative
  Scenario: Login fails with incorrect password

    Given the user is on the Demo Web Shop login page
    When the user enters a valid registered email address
    And the user enters an incorrect password
    And the user clicks the "Log in" button
    Then an error message should display "Login was unsuccessful. Please correct the errors and try again."
    And the user should remain on the login page


  @login @negative
  Scenario: Login fails with unregistered email

    Given the user is on the Demo Web Shop login page
    When the user enters an unregistered email address
    And the user enters a valid password
    And the user clicks the "Log in" button
    Then an error message "Login was unsuccessful. Please correct the errors and try again." should be displayed
    And the user should remain on the login page


  @login @negative @validation
  Scenario: Login attempt with empty credentials

    Given the user is on the Demo Web Shop login page
    When the user clicks the "Log in" button without entering credentials
    Then a validation message "Please enter your email" should be displayed
    And the user should remain on the login page


  @login @functional
  Scenario: Verify Remember Me functionality when checkbox is selected

    Given the user is on the Demo Web Shop login page
    And the user enters valid login credentials
    And the user selects the "Remember me?" checkbox
    When the user clicks the "Log in" button
    And the user closes and reopens the browser
    Then the user session should remain active
    And the logged-in user email should be displayed in the header


  @login @functional
  Scenario: Verify session is not persisted when Remember Me is unchecked

    Given the user is on the Demo Web Shop login page
    And the user enters valid login credentials
    And the "Remember me?" checkbox is unchecked
    When the user clicks the "Log in" button
    And the user closes and reopens the browser
    Then the user should be required to log in again


  @login @navigation
  Scenario: Forgot password link redirects to password recovery page

    Given the user is on the Demo Web Shop login page
    And the "Forgot password?" link is visible
    When the user clicks the "Forgot password?" link
    Then the user should be redirected to the password recovery page
    And the page title should display "Password recovery"
    And the Email input field should be visible


  @password-recovery @positive
  Scenario: Password recovery request submitted successfully

    Given the user is on the Password Recovery page
    When the user enters a registered email address
    And the user clicks the "Recover" button
    Then a success message "Email with instructions has been sent to you." should be displayed


  @password-recovery @negative
  Scenario: Password recovery attempted with unregistered email

    Given the user is on the Password Recovery page
    When the user enters an unregistered email address
    And the user clicks the "Recover" button
    Then the system should display an appropriate response message


  @password-recovery @validation
  Scenario: Validation displayed when email field is empty

    Given the user is on the Password Recovery page
    When the user clicks the "Recover" button without entering an email address
    Then a validation message should be displayed for the Email field
    And the user should remain on the Password Recovery page

