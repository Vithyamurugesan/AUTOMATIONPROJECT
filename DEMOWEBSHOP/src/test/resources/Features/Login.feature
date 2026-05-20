Feature: Haritha_19MAY2025_DEMOWEBSHOP_Feature File for Login
Description:
This feature verifies login authentication, invalid login handling, forgot password navigation,
and password recovery functionality in the Demo Web Shop application.

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
| email | password |
| dummy | dummy    |
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
      | haritha@gmail.com   | haritha  | The credentials provided are incorrect                           |
      | haritha11@gmail.com | hari     | The credentials provided are incorrect                           |
      |                     |          | No customer account found                                        |
      |                     | haritha  | No customer account found                                        |
      | haritha11@gmail.com |          | Login was unsuccessful. Please correct the errors and try again. |

  @login @navigation
  Scenario: Forgot password link redirects to password recovery page
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    And the Forgot password? link is visible
    When the user clicks the Forgot password? link
    Then the user should be redirected to the password recovery page
    And the page title should display "Password recovery"
    And the Email input field should be visible

  @password-recovery
  Scenario Outline: Verify password recovery functionality
    Given the user is on the Password Recovery page
    When the user enters a recovery email "<email>"
    And the user clicks the Recover button
    Then the system should display recovery message "<message>"

    Examples:
      | email               | message                                       |
      | haritha11@gmail.com | Email with instructions has been sent to you. |
      | harithagmail.com    | Wrong email                                   |
      |                     | Enter your email                              |
