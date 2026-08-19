@Sowndariya

Feature: Sowndariya_14Aug2026_DEMOWEBSHOP_Feature File For Recently Viewed Products Functionality

  Description:
  This feature is used to verify Recently Viewed Products functionality
  like opening the page and validating that products a user has viewed
  are correctly listed on the Recently Viewed Products page.
  Product data used for these scenarios is read from an external Excel
  file (RecentlyViewedProducts.xlsx) instead of being hardcoded in the
  feature file.

  Background:
    Given User is on Demo Web Shop Website for Recently Viewed Products

  @RecentlyViewedProductsPage
  Scenario: Verify Recently Viewed Products page opens

    When User clicks on Recently viewed products link
    Then User should be navigated to Recently Viewed Products page


  @SingleViewedProduct
  Scenario: Verify viewed product is displayed in Recently Viewed Products

    Given User views the first product from recently viewed products test data
    When User clicks on Recently viewed products link
    Then User should see the first product from test data displayed in Recently Viewed Products
    
  @MultipleViewedProducts
  Scenario: Verify multiple viewed products are displayed in Recently Viewed Products

    Given User views all products from recently viewed products test data
    When User clicks on Recently viewed products link
    Then User should see all products from test data displayed in Recently Viewed Products



