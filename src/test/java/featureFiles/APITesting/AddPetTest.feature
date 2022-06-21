@API @Pet
Feature: Checking add new feature

  Background:
    Given Building test base

  @Smoke @addNewPet
  Scenario: adding a new pet with payload
    And Authorization for the action
    When Add a new pet with addNewPet Payload and "POST" method and "addPet" API
    Then The API get success with status code 200

  @Regression @addMultiplePet
    #adding multiple pets, checking multiple pets by ids, and delete multiple pet info
    Scenario Outline: adding multiple pet
    And Authorization for the action
    When Add multiple new pets with "POST" method, "addPet" API, id= <id>, petName= "<petName>", status= "<status>"
    Then The API get success with status code 200
    And Check the pet info with "GET" method and "findPetById" API and id = <id>
    And The API get success with status code 200
    And Delete an exiting pet with id= <id> "DELETE" method and "findPetById" API

    Examples:
    |id     |petName  |status   |
    |12344  |jake     |available|
    |23344  |koda     |sold     |
    |12244  |oliver   |pending  |


  @Regression @addNewPet
  Scenario: Adding a new pet with wrong credential
    And Authorization for the action with wrong credential
    When Add a new pet with addNewPet Payload and "POST" method and "addPet" API
   # Then The API get invalid input status code 405

  @Regression @addNewPet
  Scenario: adding a new pet with wrong payload
    And Authorization for the action
    When Add a new pet with addNewPetWrong Payload and "POST" method and "addPet" API
    Then The API get invalid input status code 500