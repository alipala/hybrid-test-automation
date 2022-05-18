Feature: See packshot of an artikel
  As a user
  I want to open the foto
  so that seeing the packshot of an artikel

  Background:
    Given Preparation steps of AIS_Packshot_TC001

#  @BriefingImport
  Scenario: The user sees the packshot of an artikel
    When open the packshot detail popup
    Then should see the packshot information

  Scenario: The user sees the refresh foto working
    When disable the foto of the artikel
    And try to refresh the foto
    Then should see the packshot information and foto

