Feature: ECommerce cart functions

This scenarios are for testing the different functions related to add to cart in the homepage

  @Cart
  Scenario: Hover with mouse shows add to cart button
    Given User is on the homepage
    When User hovers the mouse over the first item
    Then User sees add to cart button

  @Cart
  Scenario: Add to cart confirmation
    Given User is on the homepage
    When User adds the first item to the cart
    Then User sees a Product successfully added to your shopping cart message

  @Cart
  Scenario: Add to cart confirmation
    Given User is on the homepage
    When User adds the first item to the cart
    And User clicks proceed to checkout
    Then User is taken to the cart page
  @Cart
  Scenario: Add to cart confirmation
    Given User is on the homepage
    When User adds the first item to the cart
    Then User sees the same price for the item in the cart
  @popo
  Scenario: Hover with mouse on the cart shows cart's items
    Given User is on the homepage
    And User adds the first item to the cart
    And User clicks continue shopping
    When User hovers with the mouse over the Cart Button
    Then User sees items in cart









