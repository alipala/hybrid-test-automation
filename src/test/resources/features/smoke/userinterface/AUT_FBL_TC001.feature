# Generate FBL1 for a particular briefing in case of there is no any problem that supplier has to care about it.
Feature: Generate FBL1
  As a user
  I want to generate contact moments
  so that informing the supplier everything looks fine

  Background:
    Given Preparation steps of AIS_FBL_TC001

#  @BriefingImport
  Scenario: The user generates Feedback Loop 1
    When generate a contact moment for FBL1
    Then should see message "Contactmomenten voor Briefing"