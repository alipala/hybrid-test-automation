Feature: See briefing history
  As a user
  I want to go the briefing history
  so that see the unsuccessful briefings

  Background:
    Given Preparation steps of TC003

  Scenario: The user see history of a briefing processed before
    When pick a failed import
    Then should see the history of a briefing


