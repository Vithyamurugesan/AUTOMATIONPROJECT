@harithaContact
Feature: Haritha_26_MAY_2025_DEMOWEBSHOP_Feature File contact

  Scenario: Verify the system behaviour for Contact Us with login
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email
    And the user enters a valid password
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the Contact us link
    Then the user should see auto-filled Name and Email fields

  Scenario: Verify the system behaviour for Contact Us without login
    Given the user is on the Demo Web Shop homepage
    When the user clicks the Contact us link
    Then the user should see empty Name and Email fields

  Scenario: Scenario: Verify the system behaviour when submitting valid enquiry details
    Given the user is on the Demo Web Shop login page
    When the user clicks the login link
    And the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the "Log in" button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the "Contact us" link
    Then the user should see auto-filled Name and Email fields
    When the user enters enquiry details
    And the user clicks the "Submit" button
    Then the user should see an appropriate successful message

  Scenario: Verify the system behaviour when submitting the enquiry form with empty fields
    Given the user is on the Demo Web Shop homepage
    When the user clicks the "Contact us" link
    And the user clicks the "Submit" button without entering details
    Then the user should see an appropriate validation error message
