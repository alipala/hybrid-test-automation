Feature: Import a briefing file
  As a user
  I want to import briefing file
  so that doing a briefing operation

  Background:
    Given Preparation steps of TC001

  @BriefingImport
  Scenario: The user imports file successfully
    When upload correct csv
    Then should see the success message "Import briefing gelukt. Klik op het"
    And should be redirected to a page title "Briefings"

  Scenario: The user be informed with an error message in case of any other files than csv
    When upload different file than csv
    Then should see the error message "Upload alleen .csv bestanden."

  Scenario: The user not import empty file
    When upload empty csv file
    Then should see the reading failed message "Briefing CSV empty.csv inlezen niet gelukt:"



