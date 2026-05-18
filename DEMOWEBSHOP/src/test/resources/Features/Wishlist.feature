Feature: Vetrivel_17MAY2026_DEMOWEBSHOP_FeatureFileforWishlist

  Description:
  As a user,
  I want to add searched products to wishlist
  so that I can save products for future purchase

  Background:
    Given user is on the home page

  @AddWishlist
  Scenario: Add product to wishlist

    When user searches and adds wishlist product from excel
    Then wishlist success message should be displayed
    And searched product should be added to the wishlist

  @RemoveWishlist
  Scenario: Remove product from wishlist

    When user searches and adds wishlist product from excel
    And user removes the product from wishlist
    Then wishlist should be empty

  @WishlistToCart
  Scenario: Add wishlist product to shopping cart

    When user searches and adds wishlist product from excel
    And user moves wishlist product to cart
    Then product should be added to shopping cart

  @DisplayWishlist
  Scenario: Verify product displayed in wishlist

    When user searches and adds wishlist product from excel
    And user navigates to wishlist page
    Then product should be displayed in wishlist