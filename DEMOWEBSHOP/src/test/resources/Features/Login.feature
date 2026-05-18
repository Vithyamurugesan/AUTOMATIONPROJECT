Feature: Haritha_13MAY2025_DEMOWEBSHOP_FeatureFileforLogin

  @login @smoke
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
| jenny04@gmail.com   | 123456   |

  @invalid
  Scenario Outline: Login with invalid credentials
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters the email "<email>"
    And the user enters the password "<password>"
    And the user clicks the Log in button
    Then an error message "<error message>" should be displayed
    And the user should remain on the login page

    Examples:
      | email               | password | error message                                                    |
      | jen@gmail.com      | jen      | The credentials provided are incorrect                           |
      | jenny04@gmail.com   | jen      | The credentials provided are incorrect                           |
      |                     |          | No customer account found                                        |
      |                     | 123456   | No customer account found                                        |
      | jenny04@gmail.com   |          | Login was unsuccessful. Please correct the errors and try again. |

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
      | jenny04@gmail.com   | Email with instructions has been sent to you. |

  @password-recovery @negative
  Scenario Outline: Password recovery attempted with invalid email
    Given the user is on the Password Recovery page
    When the user enters an invalid email "<email>"
    And the user clicks the Recover button
    Then the system should display an error message "<message>"


Examples:
| email               | password |
| jenny04@gmail.com   | 123456   |

  @password-recovery @validation
  Scenario Outline: Validation shown when email field is empty on recovery page
    Given the user is on the Password Recovery page
    When the user clicks the Recover button without entering an email
    Then a validation message "<message>" should be displayed
    And the user should remain on the Password Recovery page

    Examples:
      | message          |
      | Enter your email |
