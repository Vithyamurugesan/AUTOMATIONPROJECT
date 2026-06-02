Feature: Vetrivel_2JUNE2026_DEMOWEBSHOP_SocialMediaLinkFunctionality

  Background:
    Given user is on the Demo Web Shop home page

  @FollowUs
  Scenario Outline: Verify social media links
    When user clicks on "<LinkName>" link
    Then user should be redirected to appropriate page

    Examples:
      | LinkName |
      | Facebook | 
      | Twitter  |
      | YouTube  | 