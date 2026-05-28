@Vithya
Feature: Vithya_26MAY2026_DEMOWEBSHOP_GiftCardPurchase

  Description:
  This feature verifies the Gift Card purchase functionality
  of the DemoWebShop application.

  Background:
    Given the user is on the DemoWebShop homepage
    When the user navigates to the "Gift Cards" section



  @GiftCard @ValidPurchase
  Scenario: Verify successful virtual gift card purchase using data table

    And the user selects the "$5 Virtual Gift Card"

    And the user enters the following gift card details

      | RecipientName | RecipientEmail | SenderName |
      | John          | john@gmail.com | David      |

    And the user clicks the "Add to cart" button

    Then the product should be added to the shopping cart successfully
    And the shopping cart quantity should be updated



  @GiftCard @InvalidRecipientEmail
  Scenario Outline: Verify virtual gift card purchase with invalid recipient email

    And the user selects the "$5 Virtual Gift Card"
    And the user enters recipient name "<recipientName>"
    And the user enters recipient email "<recipientEmail>"
    And the user enters sender name "<senderName>"

    When the user clicks the giftcard button "Add to cart"

    Then the recipient email error message "<errorMessage>" should be displayed

    Examples:
      | recipientName | recipientEmail | senderName | errorMessage                |
      | John          | john           | David      | Enter valid recipient email |
      | Sam           | sam@gmail      | Peter      | Enter valid recipient email |



  @GiftCard @MandatoryFields
  Scenario: Verify gift card purchase with empty mandatory fields

    And the user selects the "$5 Virtual Gift Card"

    And the user clicks the "Add to cart" button

    Then the following gift card validation messages should be displayed

      | Field          | Message                       |
      | RecipientName  | Enter valid recipient name    |
      | RecipientEmail | Enter valid recipient email   |
      | SenderName     | Enter valid sender name       |



  @GiftCard @QuantityUpdate
  Scenario: Verify shopping cart quantity update for gift card

    And the user selects the "$5 Virtual Gift Card"

    And the user enters the following gift card details

      | RecipientName | RecipientEmail | SenderName |
      | John          | john@gmail.com | David      |

    And the user clicks the "Add to cart" button

    When the user updates the product quantity to "3"
    And the user clicks the "Update shopping cart" button

    Then the shopping cart quantity should display "3"
    And the total price should be updated correctly
