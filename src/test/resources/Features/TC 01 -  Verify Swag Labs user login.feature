Feature: TC - 01 - Verify Swag Labs with user login

  Scenario Outline: Logging to Swag Labs using <User Type>
    Given Logging to Swag Labs with <UserID> and <Password>
    When Verify the user profile and home page
    Then Verify the basic user UI elements

    Examples: 
      | User Type    | UserID          | Password     |
      | Stander user | standard_user   | secret_sauce |
      | Locked user  | locked_out_user | secret_sauce |