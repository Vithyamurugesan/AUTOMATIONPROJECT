@harithaDownload
Feature: Haritha_26_MAY_2025_DEMOWEBSHOP_Feature File downloadableProduct
Description:
This feature verifies downloadable product access 
for registered and unregistered users in the Demo Web Shop application.

  @Download
  Scenario: Verify the system displays previously downloaded products in the Downloadable Products page
    Given the user is on the Demo Web Shop login page
    When user clicks loginlink
    When the user enters a registered email
    And the user enters a valid password
    And the user clicks the Log in button
    Then the user should be redirected to the homepage
    And the logged-in user email should be displayed in the header
    When the user clicks the My account link
    When the user clicks the Downloadable products link
    Then the user should be able to see the previously downloaded product details

  @DownloadUnregister
  Scenario: Verify the system redirects unregistered users to the login page
    Given the user is on the Demo Web Shop homepage
    When the user clicks the My account link
    Then the user should be redirected to the login page
