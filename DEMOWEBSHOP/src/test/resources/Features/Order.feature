Feature: Haritha_16MAY2025_DEMOWEBSHOP_Feature File order
Description:
This feature verifies Order History functionality including 
order access, product details, PDF invoice download, and re-order operations
for registered and unregistered users in the Demo Web Shop application.

  @History @Resgister
  Scenario Outline: Verify registered user can access Order History
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the Orders link
    Then the user should see the previously ordered details

  @History @Unregister
  Scenario: Verify unregistered user is redirected to login page
    Given the user is on the Demo Web Shop homepage
    When the user clicks the Orders link
    Then the user should be redirected to the login page

  @productinformation
  Scenario Outline: Verify ordered product information is displayed correctly
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the Orders link
    Then the user should see the previously ordered details
    When the user clicks the Details button
    Then the user should see the ordered product information

  @PDF
  Scenario: Verify invoice PDF is downloaded successfully
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the Orders link
    Then the user should see the previously ordered details
    When the user clicks the Details button
    When the user clicks the PDF Invoice button
    Then the invoice PDF should be downloaded successfully

  Scenario: Verify Re-order functionality
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
     When the user enters a registered email "<email>"
    And the user enters a valid password "<password>"
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the Orders link
    Then the user should see the previously ordered details
    When the user clicks the Details button
    Then the user should see the ordered product information
    When the user clicks the Re-order button
    And the previously ordered products should be added to the cart