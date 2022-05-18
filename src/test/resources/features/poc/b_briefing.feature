@issue:#CRFC-17133
Feature: Briefing
  Description: The purpose of this feature is to test the how briefing works

  Background: User should be logged in already to make a briefing by importing .csv file
    Given user should be login as a standard user

  Scenario Outline: User should do briefing on AIS
    Given open Briefing menu
    And go to Importen sub menu
    When user open directory to find the file
    And upload .csv file
    Then see the message of successfully imported
    And see the page heading is correct after importing
    And see the particular values are correct in the table "<Jaar>", "<Week>", "<Ingangsdatum>", "<Type>", "<Code>", "<Invoer_Deadline>", "<Assortimentsgroep>", "<Creatie_Datum>"

    Examples:
    | Jaar  | Week  | 	Ingangsdatum  | Type    | Code                  | Invoer_Deadline | Assortimentsgroep               | Creatie_Datum       |
    | 2022  | 4     |   24-02-2022    | Mutatie | test_workaround_gall2 | 06-01-2022      | 381 Gemak Mixables en Likeuren  | 26-01-2022 10:44:00 |


  Scenario: Check briefing details
    When user open briefing detail of GTIN in a new tab "3269210256370"
    And open item detail
    Then user should see the MRC status button is green
