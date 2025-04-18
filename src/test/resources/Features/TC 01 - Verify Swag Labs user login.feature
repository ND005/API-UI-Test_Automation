Feature: TC - 01 - Verify Swag Labs cart functionality

  Scenario Outline: Logging to Swag Labs using <User Type>
    Given Logging to Swag Labs with <UserID> and <Password>
    When Verify the user profile and home page
    Then Verify the first product details and add to cart
    Then Verify the cart, remove the item from cart and continue the shopping
    And Terminate the browser

    Examples: 
      | User Type    | UserID        | Password     |
      | Stander user | standard_user | secret_sauce |