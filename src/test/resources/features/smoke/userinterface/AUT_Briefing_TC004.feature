Feature: Filter Briefings
  As a user
  I want to use the different filters
  so that accessing the required information

  Background:
    Given Preparation steps of TC004

  Scenario Outline: The user see the filter options
    Then should see a filter called "<Name>"
    Examples:
      |  Name                   |
      |  Column1_wtCmb_Status   |
      |  Column2_wtCmb_Filter   |
      |  Column3_wtTxtFilter    |

  Scenario Outline: The user filters the results by Status
    When pick options from "<Status>"
    Then should see the related briefings via "<Icon>" icon
    Examples:
      |  Status       |   Icon   |
      |  Open         |   red    |
      |  Gearchiveerd |   green  |

  Scenario: The user filters the results by Filter
    When pick "Open" and "Briefing type" and "WORP"
    Then should see correct briefings "WORP"

  Scenario: The user filters the results by Searchbox
    When write "Test" into searchbox
    Then should see the briefings contain "test"
