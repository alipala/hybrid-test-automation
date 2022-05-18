@issue:#CRFC-17132
@manual
@manual-result:passed
@manual-test-evidence:assets/failed_login_test_title_wrong.png
Feature: Logging
  Scenario: User should be see the monitor page after login
    Given user is on home page
    When user login as a standard user
    Then Briefingsvoortgang Monitor page should be displayed