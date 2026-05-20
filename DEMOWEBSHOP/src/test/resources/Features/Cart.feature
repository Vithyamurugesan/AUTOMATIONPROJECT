@SowndariyaFeature

Feature: Sowndariya_20MAY2025_DEMOWEBSHOP_Feature File ForShopping Cart Functionality

  Description:
  This feature is used to verify shopping cart functions
  like adding products to cart.

  Background:
    Given User is on Demo Web Shop Website


  @AddToCart
  Scenario: Add product to shopping cart

    Given User clicks on Books category
    And User clicks on Computing and Internet product
    When User clicks on Add to Cart button
    Then User should be product added to shopping cart


  @MultipleProductsCart
  Scenario: Verify user can add multiple products into shopping cart

    Given User adds multiple products from test data
    And User clicks on Shopping Cart
    Then User should see added products should be displayed in shopping cart


  @CartTotal
  Scenario: Verify shopping cart total amount

    Given User adds multiple products from test data
    And User clicks on Shopping Cart
    Then User should see added products should be displayed in shopping cart
    And User should see cart subtotal and total amount


  @EmptyCart
  Scenario: Verify empty shopping cart message

    Given User clicks on Shopping Cart without adding product
    Then User should see message as Your Shopping Cart is empty!


  @InvalidCoupon
  Scenario Outline: Verify invalid coupon code validation

    Given User clicks on Books category
    And User clicks on Add to Cart button
    And User clicks on Shopping Cart
    When User enters invalid coupon code "<coupon>"
    And User clicks on Apply Coupon button
    Then User should see the invalid message as The coupon code you entered couldn't be applied to your order

    Examples:
      | coupon   |
      | asdfg123 |
      | 1234567  |


  @InvalidGiftCard
  Scenario Outline: Verify invalid gift card code validation

    Given User clicks on Books category
    And User clicks on Add to Cart button
    And User clicks on Shopping Cart
    When User enters invalid gift card code "<giftcard>"
    And User clicks on Apply Gift Card button
    Then User should see the invalid message as The coupon code you entered couldn't be applied to your order

    Examples:
      | giftcard    |
      | gift1234    |
      | giftcard123 |


  @UpdateCart
  Scenario: Verify cart quantity update

    Given User clicks on Books category
    And User clicks on Add to Cart button
    And User clicks on Shopping Cart
    When User updates product quantity
    And User clicks on Update Shopping Cart button
    Then User should see the update quantity in shopping cart


  @RemoveCart
  Scenario: Verify remove product from shopping cart

    Given User clicks on Books category
    And User clicks on Add to Cart button
    And User clicks on Shopping Cart
    When User removes product from shopping cart
    And User clicks on Update Shopping Cart button
    Then User should see product removed from shopping cart