# See the contact moments generated before
Feature: See the contact moments
  As a user
  I want to see the contact moments
  so that ensuring the contact moment was generated before

  Background:
    Given Preparation steps of AIS_FBL_TC002

  Scenario: The user sees contact moments
    When enter to blue envelope of a briefing
    Then should see the Status is "Verzonden"

