Feature:  checkout from the cart 
Describtions: As a user i want to checkout from the cart so that i can complete my order

 Background:
    Given User is on shopping cart page

  @CHK_001
  Scenario: Checkout without selecting terms checkbox
    When User clicks checkout without selecting terms checkbox
    Then Warning message should be displayed

  @CHK_001
  Scenario: Checkout after selecting terms checkbox
    When User selects terms and conditions checkbox
    And User clicks checkout button
    Then User should navigate to checkout page