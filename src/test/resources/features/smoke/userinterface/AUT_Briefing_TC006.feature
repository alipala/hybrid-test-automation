Feature: Export a particular briefing
  As a user
  I want to export briefing
  so that seeing details of artikel in a csv file

  Background:
    Given Preparation steps of TC006

#  @BriefingImport
  Scenario: The user export the briefing csv file
#    Given upload a briefing
    Given go to detail of a briefing
    When export
    Then a csv file should be downloaded