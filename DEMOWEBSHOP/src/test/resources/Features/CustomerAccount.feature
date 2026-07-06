@jeeva @CustomerAccount
Feature: JeevaPranesh_06_07_2026_Customer Account Management

  Background: 
    Given user navigates to the demowebshop for account management
    When the user logs in for account management
    And the user clicks on their account email link at the top of the page

  Scenario Outline: user successfully update customer personal information
    When the user updates their first name to "<name>"
    And the user clicks the Save button on the customer info page
    Then the user should remain on the customer info page and see the updated first name "<expectedName>" in the first name field
    
    Examples:
        | name          |expectedName|
        | JeevaUpdated  |JeevaUpdated|
        |john|john|
        
    