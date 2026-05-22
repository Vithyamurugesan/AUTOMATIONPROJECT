Feature: Vetrivel_14MAY2025_DEMOWEBSHOP_SearchFunctionality

  Description:
  As a user,
  I want to search for products
  so that I can view products related to my search keyword

  Background:
    Given user is on the home page

  @Vetri
  @ValidSearch
  Scenario: Search product using valid keyword

    When user enters "valid" type keyword in the search box
    And clicks on Search button
    Then user should be redirected to the search results page

  @Vetri
  @InvalidSearch
  Scenario: Search using invalid keyword

    When user enters "invalid" type keyword in the search box
    And clicks on Search button
    Then no products message should be displayed

  @Vetri
  @Insensitive
  Scenario: Verify search is case insensitive

    When user enters "insensitive" type keyword in the search box
    And clicks on Search button
    Then matching products should be displayed

  @Vetri
  @WithoutKeyword
  Scenario: Search without entering keyword

    When user clicks on Search button without entering keyword
    Then warning message should be displayed to the user