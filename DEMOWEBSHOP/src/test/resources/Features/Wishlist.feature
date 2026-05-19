Feature: Wishlist functionality

  Description:
  As a user,
  I want to manage products in my wishlist
  so that I can save products for future purchase

  Background:
    Given user is on the home page

  @AddWishlist
  Scenario: Add product to wishlist

    When user searches and adds product for "AddWishlist" scenario to wishlist
    Then success message for "AddWishlist" scenario should be displayed
    And searched product should be added to the wishlist

  @RemoveWishlist
  Scenario: Remove product from wishlist

    When user searches and adds product for "RemoveWishlist" scenario to wishlist
    And user removes the product from wishlist
    Then wishlist should be empty

  @WishlistToCart
  Scenario: Add wishlist product to shopping cart

    When user searches and adds product for "WishlistToCart" scenario to wishlist
    And user moves wishlist product to cart
    Then product should be added to shopping cart

  @DisplayWishlist
  Scenario: Verify product displayed in wishlist

    When user searches and adds product for "DisplayWishlist" scenario to wishlist
    And user navigates to wishlist page
    Then product should be displayed in wishlist