Feature: Vetrivel_17MAY2025_DEMOWEBSHOP_FeatureFileForWishlist
  Background:
    Given user is on the home page

  @AddWishlist
  Scenario: Add product to wishlist

    When user searches and adds "AddWishlist" scenario product from excel to wishlist
    Then message for "AddWishlist" scenario should be displayed
    And searched product should be added to the wishlist

  @RemoveWishlist
  Scenario: Remove product from wishlist

    When user searches and adds "RemoveWishlist" scenario product from excel to wishlist
    And user removes the product from wishlist
    Then wishlist should be empty

  @WishlistToCart
  Scenario: Add wishlist product to shopping cart

    When user searches and adds "WishlistToCart" scenario product from excel to wishlist
    And user moves wishlist product to cart
    Then product should be added to shopping cart

  @DisplayWishlist
  Scenario: Verify product displayed in wishlist

    When user searches and adds "DisplayWishlist" scenario product from excel to wishlist
    And user navigates to wishlist page
    Then product should be displayed in wishlist