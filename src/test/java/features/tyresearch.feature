Feature: Tyre Search Test
  Scenario Outline: Default tyre search accessed from the main page
    Given User is on the home page "https://automall.md"
    When User clicks on the tyre search link
    Then User selects tyre width <width>
    And User selects tyre height <height>
    And User selects tyre diameter <diameter>
    And User selects tyre season <season>
    And User clicks on the show results button
    And User clicks on the row view button
    And Results are present on the page
    And All the product codes with quantity more that zero are printed in the console
    And Close browsers TyreSearch

    Examples:
      | width | height | diameter | season |