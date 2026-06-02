Feature: Vetrivel_26MAY2026_DEMOWEBSHOP_AddressFunctionality

  Background:
    Given user is on the address page

  @Vetri
  @ValidAddress
  Scenario Outline: Add valid address
    When user clicks on Add new button
    And user enters address details from excel "<RowNumber>"
    And user clicks on Save button
    Then address should be added successfully

    Examples:
      | RowNumber |
      | 1 |
      | 5 |
      | 6 |

  @Vetri
  @Address @InvalidAddress
  Scenario Outline: Add invalid address
    When user clicks on Add new button
    And user enters address details from excel "<RowNumber>"
    And user clicks on Save button
    Then address validation should be displayed

    Examples:
      | RowNumber |
      | 2 |
      | 3 |
      | 4 |

  @Vetri
  @Address @EmptyAddress
  Scenario: Verify validation messages for empty address form
    When user clicks on Add new button
    And user clicks on Save button
    Then address validation should be displayed