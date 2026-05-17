Feature: Vetrivel_17MAY2026_DEMOWEBSHOP_FeatureFileforWishlist

  Description: As a user, I want to add and manage products in wishlist
  so that I can save products for future purchase

  Background:
    Given user is on the home page

  @AddToWishlist
  Scenario: Add product to wishlist
    When user navigates to a product page
    And clicks on Add to wishlist button
    Then success message should be displayed
    And product should be added to the wishlist

  @DisplayWishlistProduct
  Scenario: Verify added product is displayed in wishlist
    When user adds a product to wishlist
    And user navigates to wishlist page
    Then added product should be displayed in the wishlist

  @RemoveWishlistProduct
  Scenario: Remove product from wishlist
    When user adds a product to wishlist
    And user navigates to wishlist page
    And user removes the product from wishlist
    Then wishlist should display empty message

  @AddWishlistProductToCart
  Scenario: Add wishlist product to shopping cart
    When user adds a product to wishlist
    And user navigates to wishlist page
    And user selects the product for adding to cart
    And clicks on Add to cart button
    Then product should be added to the shopping cart