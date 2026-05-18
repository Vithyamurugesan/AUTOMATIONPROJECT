Feature: Haritha_16MAY2025_DEMOWEBSHOP_FeatureFiledownloadableProduct
@Download
Scenario Outline: Verify the system displays previously downloaded products in the Downloadable Products page

Given the user is on the Demo Web Shop login page
When user clicks loginlink
And the user enters a registered email "<email>"
And the user enters a valid password "<password>"
And the user clicks the Log in button
Then the user should be redirected to the homepage
And the logged-in user email should be displayed in the header

When the user clicks the My account link
When the user clicks the Downloadable products link
Then the user should be able to see the previously downloaded product details

Examples:
| email               | password |
| jenny04@gmail.com   | 123456   |



@DownloadUnregister
Scenario: Verify the system redirects unregistered users to the login page

Given the user is on the Demo Web Shop homepage
When the user clicks the My account link
Then the user should be redirected to the login page
