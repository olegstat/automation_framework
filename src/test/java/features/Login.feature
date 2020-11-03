Feature: Site Login
  Scenario: Default login from the home page
    Given Unlogged user is on the home page
    When User logs in with username and password
    Then User is successfully logged in
    And Correct UserID is displayed on the page