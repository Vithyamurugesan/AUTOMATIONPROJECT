Feature: Vithya_18MAY2026_DEMOWEBSHOP_FeatureFileforCatalog
  Description: As a user, I want to navigate through product categories
  so that I can view products listed in each catalog section

  Background:
    Given user is on the demowebshop home page for Categories

  @CategoryNavigation
  Scenario: Verify category navigation - Computers
    When user clicks on the Computers category from top menu
    Then user should be navigated to the selected category page
    And the category page title should be displayed

  @CategoryNavigation
  Scenario: Verify category navigation - Electronics
    When user clicks on the Electronics category from top menu
    Then user should be navigated to the selected category page
    And the category page title should be displayed

  @CategoryNavigation
  Scenario: Verify category navigation - Books
    When user clicks on the Books category from top menu
    Then user should be navigated to the selected category page
    And the category page title should be displayed

  @CategoryNavigation
  Scenario: Verify category navigation - Apparel and Shoes
    When user clicks on the Apparel and Shoes category from top menu
    Then user should be navigated to the selected category page
    And the category page title should be displayed

  @CatalogProducts
  Scenario: Verify products displayed in catalog - Gift Cards
    When user clicks on the Gift Cards category from top menu
    Then the product grid should be visible on the page
    And products should be listed in the catalog
