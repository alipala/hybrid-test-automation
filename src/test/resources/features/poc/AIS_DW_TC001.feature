Feature: DW Upload
  As a user
  I want to import DW file
  so that making a Data change operation

  Background:
    Given Preparation steps of AIS_DW_TC001

  Scenario: The user imports DW file successfully
    Given goto "Datawijziging uploaden in AIS" screen
    When upload DW file
    Then should see the success message popup



