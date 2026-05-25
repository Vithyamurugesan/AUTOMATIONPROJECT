@jeeva
Feature: Product Review validation


Background: 
Given user is on the demoWebshop website

Scenario: Give a review for a product without login
When the user clicks on a product to view its details
When the user click  the review button 
Then the user shoulod should redirect to the product review page and seen the text of product review 
And the user see the text of only registered users can write reviews
