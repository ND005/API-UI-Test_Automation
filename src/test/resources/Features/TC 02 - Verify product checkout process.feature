Feature: TC - 02 - Verify Swag Labs complete checkout functionality

  Scenario Outline: TS 01 - Verify product checkout functionality of Swag Labs
    Given Logging to Swag Labs with <UserID> and <Password>
    When User logged into standard profile
    Then Verify multiple products select process
    Then Verify order procedure till checkout
    Then Verify checkout information section with and without data
    Then Verify checkout overview section and its all expected fields
    And Verify order confirmation section and get back to Home page
    And Terminate the browser

    Examples: 
      | UserID        | Password     |
      | standard_user | secret_sauce |