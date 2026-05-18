Feature: JeevaPranesh_13MAY2026_To procedure check out page from cart

description: As a user, I want to be able to proceed to the checkout page from the cart so that I can complete my purchase.

Background: 
Given user is on the demoWebPage website

@scenario_1
Scenario: procedure to checkout as registered user
Given user is login the demo web shop website with minium adding of one product
When the user click the checkbox of terms and conditions
And the user click the checkout button
Then the user redirect to the checkout page and seen the text of checkout 


@scenario_2 
Scenario: Procedure to checkout as a guest user

Given the user adds at least one product to the cart without logging in
When the user click the checkbox of terms and conditions
And the user click the checkout button
Then the user should be redirected to the login page and see the text Welcome, Please Sign In
When the user clicks the Checkout as Guest button
Then the user redirect to the checkout page and seen the text of checkout 
 
 @scenario_3
Scenario: Proceed to checkout as a registered user after registration

Given the user adds at least one product to the cart without logging in
When the user click the checkbox of terms and conditions
And the user click the checkout button
Then the user should be redirected to the login page and see the text Welcome, Please Sign In
When the user clicks the Register button
Then the user should redirect to the Register page and seen the text of Register
When the user fill all the required information
Then the user seen the text of user registeration is completed
When the user click continue button
And the user click the checkbox of terms and conditions
And the user click the checkout button
Then the user redirect to the checkout page and seen the text of checkout

@scenario_4
Scenario:  Completed a Billing AddressForm with Valid credentials
Given the user is in the checkout page
When the user dill the billing address form with valid credentials
|FirstName|LastName|Email|Company|Country|state|City|Address1|Address2|ZipCode|Phone|Fax number|
|jeeva|pranesh|jeeva@gmail.com|expleo|1|0|Salem| sivaji nagar| sivaji bagar|636004|9876543210|1234567890|
And the user click the Continue button
Then the user should seen the Shipping Addres form with text of Select a shipping address from your address book or enter a new address.


@scenario_5
Scenario: fill the billing Address with invalid credentials
Given the user is in the checkout page
When the user dill the billing address form with invalid credentials of email
|FirstName|LastName|Email|Company|Country|state|City|Address1|Address2|ZipCode|Phone|Fax number|
|jeeva|pranesh|jeevagmail.com|expleo|1|0|Salem| sivaji nagar| sivaji bagar|636004|9876543210|1234567890|
And the user click the Continue button
Then the user should see the error message of Wrong email

@scenario_6
Scenario Outline: Selecting a Address in the Shipping Address section
Given the user in the checkout pages of shipping section
When the user select the Address from the dropdown and select "<Address>"
And the user click the continue button in shipping section
Then the user move to the Shipping method and seen the text of Ground
 
 Examples:
|Address|
|0		|

@scenario_7
Scenario: selecting in-store pickup checkout
Given the user in the checkout pages of shipping section
When the user click the checkBox of In-Store Pickup
And the user click the continue button in shipping section
Then the user move to direct to the Payment method

@scenario_8
Scenario: selecting a cash on delivery feature and verify the payment information
Given the user is in the checkout page of payment method section
When the user is click the cash On Delivey in the payment section
And the user click the continue button of payment section
Then the user should redirect to the payment information and seen text you will pay by COD

@scenario_9
Scenario: selecting a credit card in the payment section 
Given the user is in the checkout page of payment method section
When the user is click the credit card checkout in the payment section
And the user click the continue button of payment section
Then the user should see the select credit card text
When the user fill the credit card infomation
|cardholder_name  |card_number      |card_code|
|Jeeva Pranesh    |4111111111111111 |123      |
And the user click the continue After Select the credit card details
Then the order conformation page is dispayed and seen the  text of total


@scenario_10
Scenario: verify the order is purchase succesfull
Given the user is in the conform page
When the user click the conform button
Then the user is redirect to the Thankyou page with text Your order has been successfully processed!



