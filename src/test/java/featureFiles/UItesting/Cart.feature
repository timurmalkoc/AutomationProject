@UI @Regression @Cart
Feature: Cart
Background:
  Given I lands on home page

  @AddItem
  Scenario: adding single item in the cart
    When I add first item on landing page
    Then I should see it in the cart
    And I should see price in my cart which matches on the item
    And close browser

  @AddMultipleItem
  Scenario: adding multiple items in the cart
    When I add multiple items on landing page
    Then I should see them in the cart
    And I should see the total price calculated right
    And close browser

  @DeleteItem
  Scenario: deleting an item from the cart
    When I add first item on landing page
    Then I should see it in the cart
    When I click delete link
    Then Item should be deleted
    And close browser

  @RefreshCart
  Scenario: Refreshing page after adding an item in the cart
      When I add first item on landing page
      Then I should see it in the cart
      When I refresh the page
      Then I should see it in the cart
      And close browser

  @Purchase @Smoke
  Scenario: Adding and item and process to payment
    When I add first item on landing page
    And I click place order btn
    And I filled the purchase with name= "Jhon Cooper", country= "USA", city= "FairFax", credit cart= "12345" month= "10", year= "25"
    And I get success message with "Thank you for your purchase!"
    And close browser

  @Purchase
  Scenario: Try to process to payment without adding any item in cart
    When I click cart
    And I click "Place Order Button"
    # Then It should get an error message
    # found bug in this scenario
    And close browser