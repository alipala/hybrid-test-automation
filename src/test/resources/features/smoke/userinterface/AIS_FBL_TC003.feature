# Feature: Delete contact of a particular briefing if not sent yet
Feature: Delete contact moment
  As a user
  I want to delete contact
  so that no need to see anymore

  Background:
    Given Preparation steps of AIS_FBL_TC003

#  @BriefingImport
  Scenario: The user deletes contact detail that has not yet been sent
    When delete contact moment
    Then confirm "Wilt u dit contactmoment verwijderen?" message
