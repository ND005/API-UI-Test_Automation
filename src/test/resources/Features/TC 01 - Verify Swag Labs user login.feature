Feature: TC - 01 - Verify Swag Labs cart functionality

  Scenario Outline: TS01 - Verify cart functionality of Swag Labs using <User Type>
    Given Logging to Swag Labs with <UserID> and <Password>
    When Verify the user profile and home page
    Then Verify the first product details and add to cart
    Then Verify the cart, remove the item from cart and continue the shopping
    And Terminate the browser

    Examples: 
      | User Type    | UserID        | Password     |
      | Stander user | standard_user | secret_sauce |

  Scenario Outline: TS02 - Verify sort dropdown functionality of Swag Labs
    Given Logging to Swag Labs with <UserID> and <Password>
    When User logged into standard profile
    Then Verify the sort functionality based on price
    And Terminate the browser

    Examples: 
      | UserID        | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: TS03 - Verify the menu bar functionality of Swag Labs
    Given Logging to Swag Labs with <UserID> and <Password>
    When User logged into standard profile
    Then Verify all the string value in menu bar with expected texts
    And Verify all navigation of menu bar
    And Terminate the browser

    Examples: 
      | UserID        | Password     |
      | standard_user | secret_sauce |

  # Expected menu bar texts was provided from excel
  # As a data driven techniqe
  @testRun
  Scenario Outline: TS04 - Verify the complete flow of product ordering functionality in Swag Labs
    Given Logging to Swag Labs with <UserID> and <Password>
    When User logged into standard profile
    Then Verify cart elements and checkout functionality
    And Verify checkout information section with and without data
    And Verify checkout overview section and its all expected fields
    And Verify order confirmation section and get back to Home page
    And Terminate the browser

    Examples: 
      | UserID        | Password     |
      | standard_user | secret_sauce |
	# checkout information and checkout overview data was provided in excel
	# As a data driven techniqe
