Feature: Tyre Search

  Scenario Outline: Default tyre search accessed from the main page
    Given User is on the home page "https://automall.md"
    When User clicks on the tyre search link
    And User selects tyre <width>
    And User selects tyre <height>
    And User selects tyre <diameter>
    And User selects tyre <season>
    And User clicks on the show results button
    And User clicks on the row view button
    Then Results are present on the page
    And All the product codes with quantity more that zero are printed in the console
    And Close browsers
    Examples:
      | width | height | diameter | season |

