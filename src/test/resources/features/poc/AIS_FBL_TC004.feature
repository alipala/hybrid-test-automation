# Feature: Generate FBL2 for a particular briefing in case of some problems that supplier need to solve
Feature: Generate FBL2
  As a user
  I want to generate contact moments
  so that informing the supplier there is a problem

  Background:
    Given Preparation steps of AIS_FBL_TC004

#  @BriefingImport
  Scenario: The user generates Feedback Loop 2
    When generate a contact moment FBL2
    Then should see the message "Email succesvol verzonden"

