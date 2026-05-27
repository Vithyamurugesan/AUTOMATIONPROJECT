@SowndariyaCompare

Feature: Sowndariya_27MAY2026_DEMOWEBSHOP_Compare Product Functionality

  Description:
  This feature verifies compare product functionality
  like adding, removing, and clearing compared products.

  Background:
  Given User launches Demo Web Shop app


 @AddSingleCompareProduct
Scenario: Verify user can add single product to compare list

  Given User clicks on Jewelry category
  And User clicks on Black And White Diamond Heart product
  When User clicks on Add To Compare button
  And User clicks on Compare Products link
  Then User should navigate to compare products page
  And User should see selected compare product in compare products page


  @AddMultipleCompareProducts
  Scenario: Verify user can add multiple products to compare list

    When User adds multiple compare products from test data
    And User clicks on Compare Products link

    Then User should navigate to compare products page
    And User should see all added products in compare products page


  @RemoveCompareProduct
  Scenario: Verify user can remove compared product

    Given User clicks on Jewelry category

    When User adds below compare products to compare list
      | product                    |
      | Black & White Diamond Heart |
      | Diamond Tennis Bracelet     |

    And User clicks on Compare Products link

    And User removes below compare product
      | product                  |
      | Diamond Tennis Bracelet  |
    And User click the remove button 
    Then User should not see removed product in compare products page
    And User should see remaining products in compare products page


  @ClearCompareList
  Scenario Outline: Verify user can clear compare product list

    Given User clicks on Jewelry category

    When User adds "<product>" product to compare list

    And User clicks on Compare Products link

    And User clicks on Clear List button

    Then User should see compare list is empty

    Examples:
      | product                     |
      | Black & White Diamond Heart |
      | Diamond Tennis Bracelet     |
      | Diamond Pave Earrings       |