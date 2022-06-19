@API @Pet
Feature: Update a current pet info
  @Regression @Update
  Scenario: Update a an existing pet in the system
    Given Building test base
    When update a existing pet id=1 with addNewPet Payload name "Updated" and "PUT" method and "addPet" API
    Then The API get success with status code 200
    And Get updated name must be "Updated"

    @Regression @invalidUpdate
  Scenario: Try update a pet with invalid id
    Given Building test base
    When update a existing pet id=123456117 with addNewPet Payload name "Updated" and "PUT" method and "addPet" API
  # Then The API get invalid input status code 404


