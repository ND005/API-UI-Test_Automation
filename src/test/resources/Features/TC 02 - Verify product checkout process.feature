Feature: TC - 02 - Verify Swag Labs complete checkout functionality

  Scenario Outline: TS 01 - Verify product checkout functionality of Swag Labs
    Given Logging to Swag Labs with <UserID> and <Password>
    When User logged into standard profile
    Then Verify multiple products select process
    And Terminate the browser

    Examples: 
      | UserID        | Password     |
      | standard_user | secret_sauce |