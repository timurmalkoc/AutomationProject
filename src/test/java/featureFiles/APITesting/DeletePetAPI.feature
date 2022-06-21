  @API @Pet
  Feature: Delete pet api
    Background:
      Given Building test base
      And Authorization for the action

    @DeleteAPI @Regression
      #the id must be valid which means pet must be in the system
    Scenario: Delete an existing pet in the system
      When Delete an exiting pet with id= 1235 "DELETE" method and "findPetById" API
      Then The API get success with status code 200

    @DeleteAPI @Regression
    Scenario: Try delete non-existing pet in the system
      When Delete an exiting pet with id= 123456700 "DELETE" method and "findPetById" API
      Then The API get success with status code 404