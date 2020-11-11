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
    And User selects hundred value per page
    And All the product codes are saved in excel
    And Tyre <season> corresponds
    And Tyre <width> corresponds
    And Tyre <height> corresponds
    And Tyre <diameter> corresponds
    And Close browsers TyreSearch
    Examples:
      | width | height |  diameter |  season |
      | 175  |  65 | 14 |  Зимние шины |

