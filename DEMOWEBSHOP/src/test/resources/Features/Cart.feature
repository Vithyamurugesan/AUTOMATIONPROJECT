Feature: Shopping Cart Functionality

  Description:
  This feature is used to verify shopping cart functions
  like adding products to cart.

  Background:
  Given User is on Demo Web Shop Website

  @AddToCart
  Scenario: Add product to shopping cart

    Given User is on product details page
    When User clicks on Add to Cart button
    Then Product should be added to shopping cart

  @MultipleProductsCart
  Scenario: Add multiple products to shopping cart

    When User adds multiple products to cart
      | productName            |
      | Computing and Internet |
      | Fiction                |
      | 14.1-inch Laptop       |
    Then All products should be added to shopping cart
    
    
    @CartTotal
Scenario: Verify shopping cart total amount

  Given User added multiple products to shopping cart
  And User navigates to shopping cart page
  Then Added products should be displayed in shopping cart
  And Cart subtotal and total amount should be displayed correctly


@EmptyCart
Scenario: Verify empty shopping cart message

  Given User navigates to shopping cart page without adding any product
  Then User should see message as "Your Shopping Cart is empty!"


@InvalidCoupon
Scenario Outline: Verify invalid coupon code validation

  Given User added product to shopping cart
  And User navigates to shopping cart page
  When User enters invalid coupon code "<coupon>"
  And User clicks on Apply Coupon button
  Then User should see the invalid message "The coupon code you entered couldn't be applied to your order" 

Examples:
  | coupon        |
  | asdfg123      |


@InvalidGiftCard
Scenario Outline: Verify invalid gift card code validation

  Given User added product to shopping cart
  And User navigates to shopping cart page
  When User enters invalid gift card code "<giftcard>"
  And User clicks on Apply Gift Card button
  Then User should see the invalid message "The coupon code you entered couldn't be applied to your order"

Examples:
  | giftcard         |
  | gift1234         |
  
  @UpdateCart
Scenario: Verify cart quantity update

  Given User added product to shopping cart
  And User navigates to shopping cart page
  When User updates product quantity
  And User clicks on Update Shopping Cart button
  Then Updated quantity should be displayed in shopping cart
  
  
  @RemoveCart
Scenario: Verify remove product from shopping cart

  Given User added product to shopping cart
  And User navigates to shopping cart page
  When User removes product from shopping cart
  And User clicks on Update Shopping Cart button
  Then Product should be removed from shopping cart