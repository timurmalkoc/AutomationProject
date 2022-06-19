#Timur
@DB
  Feature: Testing Actor table

    Scenario Outline: Checking Queries-Insert,Update,Delete,Select
      Given I connect DB
      When I Add an actor with "<actor_name>" and "<actor_lastname>" table
      Then I should see the actor in actor table
      When I update actor name with "<update_name>"
      Then I should see the actor in actor table
      When I delete actor
      Then I shouldn't see the actor
      And I disconnect from DB

      Examples:
      |actor_name | actor_lastname| update_name |
      |Veli       | cooper        | Kareem       |