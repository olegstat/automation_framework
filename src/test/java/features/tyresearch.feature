Feature: Tyre Search Test
  Scenario Outline: Default tyre search test
    Given User is on the home page "https://automall.md"
    When User clicks on the tyre search link
    Then User selects tyre width <width>
    And User selects tyre height <height>
    And User selects tyre diameter <diameter>
    And User selects tyre season <season>
    And User clicks on the show results button
    And User clicks on the row view button
    And Results are present on the page
    And All the product codes with quantity more than zero are printed in the console
    And Close browsers TyreSearch
    Examples:
      | width | height |  diameter |  season |
      | 100  |  200 | 15 |  winter |

