@Vetri
Feature: Vetrivel_17MAY2025_DEMOWEBSHOP_WishlistFunctionality

  Description:
  As a user,
  I want to manage products in my wishlist
  so that I can save products for future purchase

  Background:
    Given user is on the home page

  @AddWishlist
  Scenario Outline: Add product to wishlist

    When user adds "<product>" to wishlist
    Then success message "The product has been added to your wishlist" should be displayed
    And product should be added to wishlist

    Examples:
      | product                |
      | Health Book            |
      | Blue and green Sneaker |

  @RemoveWishlist
  Scenario: Remove product from wishlist

    When user adds product to wishlist
    And user removes product from wishlist
    Then wishlist message "The wishlist is empty!" should be displayed

  @WishlistToCart
  Scenario: Move wishlist product to cart

    When user adds product to wishlist
    Then success message "The product has been added to your wishlist" should be displayed
    And product should be added to cart

  @DisplayWishlist
  Scenario Outline: Verify product displayed in wishlist

    When user adds "<product>" to wishlist
    And user navigates to wishlist page
    Then product should be displayed in wishlist

    Examples:
      | product                     |
      | Health Book                 |
      | Black & White Diamond Heart |
      | Blue and green Sneaker      |