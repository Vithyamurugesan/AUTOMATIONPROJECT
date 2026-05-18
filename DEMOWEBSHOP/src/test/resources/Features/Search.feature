Feature: Vetrivel_13MAY2025_DEMOWEBSHOP_FeatureFileforLogin

  Description: As a user, I want to search an item in the search box
  so that I can view products related to my search keyword

  Background:
    Given user is on the home page

  @ValidSearch
  Scenario Outline: Search product using valid keyword

    When user enters product keyword in the search box
      | keyword  |
      | <keyword> |

    And clicks on Search button
    Then user should be redirected to the search results page

    Examples:
      | keyword  |
      | Laptop   |
      | Book     |
      | Computer |
      | Phone    |

  @InvalidSearch
  Scenario Outline: Search using invalid keyword

    When user enters product keyword in the search box
      | keyword  |
      | <keyword> |

    And clicks on Search button
    Then no products message should be displayed

    Examples:
      | keyword |
      | abcxyz  |
      | test123 |
      | invalid |

  @Insensitive
  Scenario Outline: Verify search is case insensitive

    When user enters product keyword in the search box
      | keyword  |
      | <keyword> |

    And clicks on Search button
    Then matching products should be displayed

    Examples:
      | keyword  |
      | COMPUTER |
      | LAPTOP   |
      | BOOK     |

  @WithoutKeyword
  Scenario: Search without entering keyword

    When user clicks on Search button without entering keyword
    Then alert should be shown to the user