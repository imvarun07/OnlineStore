Feature: End to End Smoke Test

Scenario: Place order and validate amount
Given user is on Home page
When he Choose to View Laptops
And he adds "Sony vaio i5" to cart
And he clicks on Home Page
And he Choose to View Laptops
And he adds "Dell i7 8gb" to cart
And he navigates to Cart Page
And he deletes "Dell i7 8gb" from cart
And he clicks on place order
And he enters his personal information
And he clicks on purchase
Then he is shown a confirmation message
And is able to validate the amount
Then he clicks on OK