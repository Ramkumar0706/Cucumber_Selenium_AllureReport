@CarFeature
Feature: Cart Functionality
  As a user
  I want to add products to my cart
  So that I can view them before purchasing

  Background:
    Given the user is on the Home Page
    And the user is logged in

  @cart
  Scenario: Add a product to the cart and view cart items
    When the user adds "Active Shoes" to the cart
    Then the user should see "Active Shoes" in the cart
    And the cart should display the correct number of items

  Scenario: View an empty cart
    Given the user navigates to the cart
    Then the cart should be empty