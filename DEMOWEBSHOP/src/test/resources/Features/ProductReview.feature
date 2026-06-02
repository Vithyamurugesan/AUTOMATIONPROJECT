@Ignore
Feature: JeevaPranesh_22May2026_Product Review validation_Updated_25May2026

Background: 
Given user is on the demoWebshop website


@productReview_without_login
Scenario: Give a review for a product without login
When the user clicks on a product to view its details
When the user click  the review button 
Then the user shoulod should redirect to the product review page and seen the text of product review 
And the user see the text of only registered users can write reviews

@Ignore
@productReview_with_login
Scenario Outline:  give a review for a product with login 
When the user login with valid creditials information
When the user clicks on a product to view its details
When the user click  the review button 
Then the user shoulod should redirect to the product review page and seen the text of product review
When the user give the reviewTile as "<reviewTitle>"
And the user give the reviewText as "<reviewText>"
And the user click the submit review button
Then the user should see the message of Product review is successfully added.

Examples:
|reviewTitle|reviewText|
|Good product |it is very nice and usefull|
|average product |it is not over hype|
|bad product | it is very worst|
|not recomendal| it is not preferable one|
