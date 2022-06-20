@API
Feature: Validating finds pets by status and id
  @findPetByStatus @pet @Regression
  Scenario Outline: Checking pets' status as available, pending, sold
    Given Building test base
    When Check pets "<status>" with "GET" method with "findByStatus" API
    Then The API get success with status code 200

    Examples:
      |status       |
      |available    |
      |pending      |
      |sold         |
      |sold, pending|

  @findPetById @Pet @Regression
  Scenario: Searching the first available by id
    Given Building test base
    When Check pets "available" with "GET" method with "findByStatus" API
    Then The API get success with status code 200
    And Get the first available pet's id
    When Check the pet info with "GET" method with "findPetById" API
    Then The API get success with status code 200

  @findPetById @Pet @Regression
  Scenario: Searching a pet with invalid an id
    Given Building test base
    When Check the pet info with "GET" method and "findPetById" API and id = 1238878
    Then The API get invalid Id supplied with code status 404