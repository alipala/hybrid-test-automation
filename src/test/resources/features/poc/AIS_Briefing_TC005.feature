Feature: Delete a briefing from overview
  As a user
  I want to delete an article
  so that deleting the article from AIS

  Background:
    Given Preparation steps of TC005

  Scenario: The user deletes an artikel not yet submitted to NASA
    When delete a briefing
    Then should see the confirm message "Wilt u deze briefing verwijderen?"
