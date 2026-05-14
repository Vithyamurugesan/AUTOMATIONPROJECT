Feature: Search Functionality

Description: As a user,I want to search a item on the search box So that I can view products related to my search keyword

  Scenario: Search product using valid keyword
    Given user is on the home page
    When user enters valid product keyword in the search box
    And clicks on Search button
    Then user should be redirected to the search results page

  Scenario: Search using invalid keyword
    Given user is on the home page
    When user enters invalid product keyword in the search box
    And clicks on Search button
    Then no products message should be displayed

  Scenario: Verify search is case insensitive
    Given user is on the home page
    When user enters product keyword in uppercase
    And clicks on Search button
    Then matching products should be displayed