Feature: Haritha_13MAY2025_DEMOWEBSHOP_FeatureFileforLogin

  @login @smoke @positive
  Scenario Outline: Successful login with valid credentials
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    And the Log out link should be visible

    Examples:
      | email               | password |
      | haritha11@gmail.com | haritha  |

  @login @negative
  Scenario Outline: Login with invalid credentials
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters the email "<email>"
    And the user enters the password "<password>"
    And the user clicks the Log in button
    Then an error message "<error message>" should be displayed
    And the user should remain on the login page

    Examples:
      | email               | password | error message                                                                                          |
      | haritha@gmail.com   | haritha  | The credentials provided are incorrect |
      | haritha11@gmail.com | hari     | The credentials provided are incorrect |                                         
      |                     |          | No customer account found              |                                        
      |                     | haritha  | No customer account found              |                                        
      | haritha11@gmail.com |          |Login was unsuccessful. Please correct the errors and try again.|
                                        

  @login @navigation
  Scenario: Forgot password link redirects to password recovery page
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    And the Forgot password? link is visible
    When the user clicks the Forgot password? link
    Then the user should be redirected to the password recovery page
    And the page title should display "Password recovery"
    And the Email input field should be visible

  @password-recovery @positive
  Scenario Outline: Password recovery request submitted successfully
    Given the user is on the Password Recovery page
    When the user enters a recovery email "<email>"
    And the user clicks the Recover button
    Then a success message "<message>" should be displayed

    Examples:
      | email               | message                                       |
      | haritha11@gmail.com | Email with instructions has been sent to you. |

  @password-recovery @negative
  Scenario Outline: Password recovery attempted with invalid email
    Given the user is on the Password Recovery page
    When the user enters an invalid email "<email>"
    And the user clicks the Recover button
    Then the system should display an error message "<message>"

    Examples:
      | email            | message     |
      | harithagmail.com | Wrong email |

  @password-recovery @validation
  Scenario Outline: Validation shown when email field is empty on recovery page
    Given the user is on the Password Recovery page
    When the user clicks the Recover button without entering an email
    Then a validation message "<message>" should be displayed
    And the user should remain on the Password Recovery page

    Examples:
      | message          |
      | Enter your email |
