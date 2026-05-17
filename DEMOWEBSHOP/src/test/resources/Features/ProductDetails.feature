Feature: Sowndariya_17May2026_DEMOWEBSHOP_Product Details Functionality

  Background:
    Given User launches Demo Web Shop application

  @ProductDetails
  Scenario: Verify product details page

    When User clicks Books category
    And User selects "Computing and Internet" product
    Then Product details page should be opened
    And Product name should be displayed as "Computing and Internet"
    And Product price should be displayed
    And Product description should be displayed
    And Product image should be displayed


  @Availability
  Scenario: Verify product availability

    When User clicks Books category
    And User selects "Computing and Internet" product
    Then Product availability should be "In stock"


  @InvalidQuantity
  Scenario Outline: Verify quantity validation message

    When User clicks Books category
    And User selects "Computing and Internet" product
    And User enters quantity "<qty>"
    And User clicks add to cart button
    Then User should see validation message "Quantity should be positive"

    Examples:
      | qty |
      | 0   |
      | -1  |
      | abc |