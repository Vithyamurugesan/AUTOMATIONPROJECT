Feature: Vetrivel_25MAY2025_DEMOWEBSHOP_PaginationFunctionality

  Description:
  As a user, 
  I want products to be divided into multiple pages 
  so that I can browse products in an organized and faster way.

  Background:
    Given user is on the home page
    When user clicks "books" in category
    And user selects 4 as a limit 

 @PaginationDisplay
  Scenario: Verify pagination is displayed for search results

    Then pagination should be displayed if search results exceed page limit

 @LimitChange
  Scenario: Verify products are updated when limit changes

    When user changes the product limit to 8
    Then only 8 products should be displayed in the page
    
   @PageNavigation
  Scenario: Verify user can navigate to next page

    When user clicks on next page button
    Then next set of products should be displayed