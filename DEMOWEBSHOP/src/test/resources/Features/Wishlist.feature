Feature: Vetrivel_17MAY2026_DEMOWEBSHOP_FeatureFileforWishlist

  Description:
  As a user,
  I want to add searched products to wishlist
  so that I can save products for future purchase

  Background:
    Given user is on the home page

  @AddWishlist
  Scenario Outline: Add product to wishlist

    When user searches and adds product "<product>" to wishlist
    Then message "The product has been added to your wishlist" should be displayed
    And searched product should be added to the wishlist

    Examples:
      | product                     |
      | Health Book                 |
      | Fiction EX                  |
      | Smartphone                  |
      | Black & White Diamond Heart |

  @RemoveWishlist
  Scenario Outline: Remove product from wishlist

    When user searches and adds product "<product>" to wishlist
    And user removes the product from wishlist
    Then wishlist should be empty

    Examples:
      | product     |
      | Health Book |
      | Fiction EX  |

  @WishlistToCart
  Scenario Outline: Add wishlist product to shopping cart

    When user searches and adds product "<product>" to wishlist
    And user moves wishlist product to cart
    Then product should be added to shopping cart

    Examples:
      | product     |
      | Health Book |
      | Smartphone  |

  @DisplayWishlist
  Scenario Outline: Verify added product is displayed in wishlist

    When user searches and adds product "<product>" to wishlist
    And user navigates to wishlist page
    Then product should be displayed in wishlist

    Examples:
      | product                     |
      | Health Book                 |
      | Black & White Diamond Heart |