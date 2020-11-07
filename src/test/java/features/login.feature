Feature: Login Test
  Scenario Outline: Default login and logout from the home page
    Given Unlogged user is on the home page "https://automall.md"
    When User logs in with <username> and <password>
    Then User is successfully logged in
    And Correct <userid> is displayed on the page
    And Users logs out
    And Close browsers

    Examples:
    |username |password |userid  |
    |oleg.statnii@automall.md  |lana1414 |28673 |