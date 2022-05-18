Feature: Download AIS Report
  As a user
  I want to download report
  so that ensuring all the information correct

  Background:
    Given Preparation steps of AIS_Report_TC001

  Scenario: The user downloads AIS report
    Given go to AIS Rapport page
    When download
    Then should see an excel file name contains "AIS Monitor datestamp" downloaded
    And should see the "Gisteren&Oudere" sheet fulfilled

