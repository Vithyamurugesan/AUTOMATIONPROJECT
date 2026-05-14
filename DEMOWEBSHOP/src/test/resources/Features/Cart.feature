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