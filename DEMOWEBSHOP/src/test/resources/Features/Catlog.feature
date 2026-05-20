@Vithya
Feature: Vithya_18MAY2026_DEMOWEBSHOP_Catalog

  Description: Verify category navigation and catalog products

  Background:
    Given user is on the demowebshop home page for Categories

  @CategoryNavigation
  Scenario: Verify category navigation - Computers

    When user clicks on the Computers category from top menu
    Then user should be navigated to computers page url
    And breadcrumb should contain Computers
    When user clicks on the Desktops subcategory
    Then user should be navigated to desktops page url
    And breadcrumb should contain Desktops
    And product grid should be displayed
    And displayed product count should be greater than 0


  @CategoryNavigation
  Scenario: Verify category navigation - Electronics

    When user clicks on the Electronics category from top menu
    Then product grid should be displayed
    And displayed product count should be greater than 0


  @CategoryNavigation
  Scenario: Verify category navigation - Books

    When user clicks on the Books category from top menu
    Then user should see the following products
      | Computing and Internet |
      | Fiction                |
      | Health Book            |


  @CategoryNavigation
  Scenario: Verify category navigation - Apparel and Shoes

    When user clicks on the Apparel and Shoes category from top menu
    Then breadcrumb should contain Apparel & Shoes
    And displayed product count should be greater than 0


  @CatalogProducts
  Scenario: Verify products displayed in catalog - Gift Cards

    When user clicks on the Gift Cards category from top menu
    Then product grid should be displayed
    And user should see the following products
      | $25 Virtual Gift Card   |
      | $50 Physical Gift Card  |
      | $100 Physical Gift Card |