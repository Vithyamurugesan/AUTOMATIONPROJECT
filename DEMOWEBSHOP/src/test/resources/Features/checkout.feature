Feature: To procedure check out page from cart

description: As a user, I want to be able to proceed to the checkout page from the cart so that I can complete my purchase.

Background: 
Given user is on the demoWebPage website

Scenario: procedure to checkout as registered user
Given user is login the demo web shop website with minium adding of one product
When the user click the checkbox of terms and conditions
And the user click the checkout button
Then the user redirect to the checkout page and seen the text of checkout
