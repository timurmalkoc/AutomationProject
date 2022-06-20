@API @Pet
Feature: Checking add new feature
  @Regression @addNewPet
  Scenario: Adding a new pet with wrong credential
    Given Building test base
    And Authorization for the action with wrong credential
    And Add a new pet with addNewPet Payload and "POST" method and "addPet" API
   # Then The API get invalid input status code 405

  @Smoke @addNewPet
  Scenario: adding a new pet with payload
    Given Building test base
    And Authorization for the action
    And Add a new pet with addNewPet Payload and "POST" method and "addPet" API
    Then The API get success with status code 200

  @Regression @addNewPet
  Scenario: adding a new pet with wrong payload
    Given Building test base
    And Authorization for the action
    And Add a new pet with addNewPetWrong Payload and "POST" method and "addPet" API
    Then The API get invalid input status code 500