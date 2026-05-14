Feature: Shopping Cart Functionality

  Description:
  This feature is used to verify shopping cart functions
  like adding products, updating quantity, removing items,
  checking total amount, and validating invalid inputs.

  Background:
    Given User is on Demo Web Shop application


  @AddToCart
  Scenario: Add product to shopping cart

    Given User is on product details page
    When User clicks on Add to Cart button
    Then Product should be added to shopping cart


  @MultipleProductsCart
  Scenario: Add multiple products to shopping cart

    Given User is on Demo Web Shop home page
    When User adds multiple products to cart
      | productName            |
      | Computing and Internet |
      | Fiction                |
      | 14.1-inch Laptop       |
    Then All products should be added to shopping cart


  @UpdateCartQuantity
  Scenario: Update product quantity in shopping cart

    Given User has products in shopping cart
    When User updates product quantity
    And User clicks on Update Shopping Cart
    Then Updated quantity should be displayed in cart


  @RemoveCartItem
  Scenario: Remove product from shopping cart

    Given User has products in shopping cart
    When User removes product from cart
    And User clicks on Update Shopping Cart
    Then Product should be removed from shopping cart


  @CartTotal
  Scenario: Verify shopping cart total amount

    Given User has multiple products in shopping cart
    When User opens shopping cart page
    Then Cart subtotal and total amount should be displayed correctly


  @EmptyCart
  Scenario: Verify empty shopping cart message

  Given User navigates to shopping cart page
  Then Empty cart message "Your Shopping Cart is empty!" should be displayed


  @InvalidCoupon
  Scenario Outline: Verify invalid coupon code

    Given User is on shopping cart page
    When User enters invalid coupon "<coupon>"
    And User clicks on Apply Coupon
    Then Coupon validation message should be displayed

    Examples:
      | coupon            |
      | TEST123           |
      | 23456             |
      | dfghj34567@#$%^&* |


  @InvalidGiftCard
  Scenario Outline: Verify invalid gift card code

    Given User is on shopping cart page
    When User enters invalid gift card code "<giftcard>"
    And User clicks on Apply Gift Card
    Then Gift card validation message should be displayed

    Examples:
      | giftcard          |
      | TEST123           |
      | 23456             |
      | dfghj34567@#$%^&* |