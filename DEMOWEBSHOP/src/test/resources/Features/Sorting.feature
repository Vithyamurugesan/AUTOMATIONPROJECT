Feature: Vetrivel_13AUG_2026_DEMOWEBSHOP_SortingFunctionality

  Background:
    Given user is on the Demo Web Shop home page
    And user navigates to the Book section

  @Vetri
  @Sorting
  Scenario Outline: Verify sorting functionality
    When user selects "<Order>" sorting
    Then the products should be sorted in "<Order>" order

    Examples:
      | Order |
      | Name: Z to A  |
      | Name: A to Z  |