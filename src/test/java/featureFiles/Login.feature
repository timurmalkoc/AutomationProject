#Author: Timur

  Feature: Login

    Scenario Outline: User Login
      And User is Navigated to Login Page
      When User login with username "<username>" and password "<password>"
      Then User login will be "<result>"

      Examples:
        | username  | password | result |
        | admin     | admin    | pass   |
        | timur     | timur123 | fail   |