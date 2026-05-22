@SowndariyaProductDetail

Feature: Sowndariya_21May2026_DEMOWEBSHOP_Product Details Functionality

  Background:
    Given User launches Demo Web Shop application

  @ProductDetails
  Scenario Outline: Verify product details page

    When User clicks category "<category>"
    And User selects product "<product>"
    Then Product details page should be opened
    And Product name should be displayed as "<product>"
    And Product price should be displayed
    And Product description should be displayed
    And Product image should be displayed

    Examples:
      | category | product                |
      | Books    | Computing and Internet |
      | Books    | Fiction                |
      

  @Availability
  Scenario Outline: Verify product availability

    When User clicks category "<category>"
    And User selects product "<product>"
    Then Product availability should be displayed as "<availability>"

    Examples:
      | category | product                | availability |
      | Books    | Computing and Internet | In stock     |
      | Books    | Fiction                | In stock     |

  @InvalidQuantity
  Scenario Outline: Verify quantity validation message

    When User clicks category "<category>"
    And User selects product "<product>"
    And User enters quantity "<qty>"
    And User clicks add to cart button
    Then User should see validation message "<message>"

    Examples:
      | category | product                | qty | message                     |
      | Books    | Computing and Internet | 0   | Quantity should be positive |
      | Books    | Computing and Internet | -1  | Quantity should be positive |
      | Books    | Computing and Internet | abc | Quantity should be positive |