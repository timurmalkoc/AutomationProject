@UI
Feature: Cart

  Scenario: adding single item in the cart
    Given I lands on first page
    When  I add first item on landing page
    Then I should see it in the cart
    And I should see price in my cart which matches on the item

  Scenario: adding multiple items in the cart
    Given I lands on home page
    When I add multiple items on landing page
    Then I should see them in the cart
    And I should see the total price calculated right

  Scenario: deleting an item from the cart
    Given I lands on first page
    When I add first item on landing page
    Then I should see it in the cart
    When I click delete link
    Then Item should be deleted
